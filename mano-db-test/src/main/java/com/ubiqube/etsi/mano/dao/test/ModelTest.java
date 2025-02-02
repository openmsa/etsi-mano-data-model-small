/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
package com.ubiqube.etsi.mano.dao.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import org.reflections.scanners.Scanners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.EqualsVerifierReport;
import nl.jqno.equalsverifier.Warning;

public class ModelTest {

	private static final Logger LOG = LoggerFactory.getLogger(ModelTest.class);

	private final Reflections reflections;

	public ModelTest(final String packageName) {
		final Scanner scanner = Scanners.SubTypes.filterResultsBy(a -> true);
		reflections = new Reflections(packageName, scanner);
	}

	public void test001() {
		final Map<String, Set<String>> subtype = reflections.getStore().get("SubTypes");
		subtype.forEach((x, y) -> {
			handle(x);
			y.forEach(ModelTest::handle);
		});
	}

	private static void handle(final String x) {
		if (x.startsWith("java.lang")
				|| x.startsWith("java.net")
				|| x.startsWith("com.ubiqube.etsi.mano.repository")
				|| x.startsWith("com.ubiqube.etsi.mano.service.rest.")
				|| x.startsWith("com.ubiqube.etsi.mano.dao.test")) {
			return;
		}
		try {
			realHandle(x);
		} catch (final Exception e) {
			throw new RuntimeException("" + x, e);
		}
	}

	private static void realHandle(final String x) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IntrospectionException {
		if (x.startsWith("com.ubiqube.etsi.mano.utils") || x.endsWith("Builder") || x.endsWith("BuilderImpl") || x.endsWith("Test") || !x.startsWith("com.ubiqube.etsi.mano")) {
			return;
		}
		final Class<?> clazz = Class.forName(x);
		if (clazz.isEnum()) {
			handleEnum((Class<? extends Enum>) clazz);
			return;
		}
		if (clazz.isInterface()
				|| Modifier.isAbstract(clazz.getModifiers())
				|| Exception.class.isAssignableFrom(clazz)) {
			return;
		}
		final Object obj = clazz.getConstructor().newInstance();
		final BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
		final PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
		testObject(obj, props);
	}

	private static void handleEnum(final Class<? extends Enum> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		final Enum en = Enum.valueOf(clazz, clazz.getEnumConstants()[0].name());
		en.toString();
		final Method m = ReflectionUtils.getMethodOrNull(en, "fromValue", String.class);
		if (m != null) {
			final String n = null;
			ReflectionUtils.invoke(m, en, n);
			ReflectionUtils.invoke(m, en, "badString");
			ReflectionUtils.invoke(m, en, en.toString());
		}
	}

	private static void testObject(final Object obj, final PropertyDescriptor[] props) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException, IllegalArgumentException {
		for (final PropertyDescriptor propertyDescriptor : props) {
			final Method mr = propertyDescriptor.getReadMethod();
			if (null != mr) {
				mr.invoke(obj);
			}
			final Method mw = propertyDescriptor.getWriteMethod();
			if ((null != mw) && (null != mr)) {
				final Class<?> ret = mr.getReturnType();
				if (Modifier.isAbstract(ret.getModifiers())) {
					// continue;
				}
				mw.invoke(obj, createType(ret));
			}
		}
		obj.hashCode();
		obj.toString();
		obj.equals(null);
		obj.equals(props);
		obj.equals(obj);
		final EqualsVerifierReport rep = EqualsVerifier
				.simple()
				.forClass(obj.getClass())
				.suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT, Warning.SURROGATE_KEY)
				.report();
		System.out.println("" + rep.getMessage());
	}

	private static Object createType(final Class<?> ret) throws NoSuchMethodException, SecurityException, IllegalArgumentException {
		if ("boolean".equals(ret.getCanonicalName()) || ret.isAssignableFrom(Boolean.class)) {
			return Boolean.TRUE;
		}
		if ("int".equals(ret.getCanonicalName()) || ret.isAssignableFrom(Boolean.class)) {
			return 123;
		}
		if ("long".equals(ret.getCanonicalName()) || ret.isAssignableFrom(Boolean.class)) {
			return 123L;
		}
		if ("double".equals(ret.getCanonicalName()) || ret.isAssignableFrom(Boolean.class)) {
			return 123d;
		}
		if (ret.isAssignableFrom(Set.class)) {
			return Set.of();
		}
		if (ret.isAssignableFrom(List.class)) {
			return List.of();
		}
		if (ret.isAssignableFrom(Map.class)) {
			return Map.of();
		}
		if (ret.isAssignableFrom(UUID.class)) {
			return UUID.randomUUID();
		}
		if (ret.isAssignableFrom(LocalTime.class)) {
			return LocalTime.now();
		}
		if (ret.isAssignableFrom(LocalDateTime.class)) {
			return LocalDateTime.now();
		}
		if (ret.isAssignableFrom(OffsetDateTime.class)) {
			return OffsetDateTime.now();
		}
		if (ret.isAssignableFrom(ZonedDateTime.class)) {
			return ZonedDateTime.now();
		}
		if (ret.isAssignableFrom(Long.class)) {
			return Long.valueOf(123);
		}
		if (ret.isAssignableFrom(Integer.class)) {
			return Integer.valueOf(123);
		}
		if (ret.isAssignableFrom(Double.class)) {
			return Double.valueOf(123D);
		}
		if (ret.isAssignableFrom(BigDecimal.class)) {
			return BigDecimal.ONE;
		}
		if (ret.isAssignableFrom(URI.class)) {
			return URI.create("http://localhost/");
		}
		if (ret.isAssignableFrom(URL.class)) {
			try {
				return URI.create("http://localhost/").toURL();
			} catch (final MalformedURLException e) {
				throw new RuntimeException(e);
			}
		}
		return createComplex(ret);
	}

	private static Object createComplex(final Class<?> ret) throws NoSuchMethodException, SecurityException, IllegalArgumentException {
		if (ret.isEnum()) {
			final Object[] cst = ret.getEnumConstants();
			return cst[0];
		}
		try {
			final Constructor<?> ctor = ret.getConstructor();
			return ctor.newInstance();
		} catch (final InstantiationException | IllegalAccessException | InvocationTargetException e) {
			LOG.trace("", e);
			return null;
		}
	}
}
