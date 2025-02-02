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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jspecify.annotations.Nullable;

public class ReflectionUtils {

	private ReflectionUtils() {
		//
	}

	public static Set<Class<?>> getGenericTypes(final ParameterizedType parameterizedType) {
		final Set<Class<?>> genericTypes = new LinkedHashSet<>();
		for (final Type genericType : parameterizedType.getActualTypeArguments()) {
			if (genericType instanceof Class<?>) {
				genericTypes.add((Class<?>) genericType);
			}
		}
		return genericTypes;
	}

	public static Method getMethodOrNull(final Object target, final String methodName, final Class<?>... parameterTypes) {
		try {
			return getMethod(target.getClass(), methodName, parameterTypes);
		} catch (final RuntimeException e) {
			return null;
		}
	}

	public static Method getMethod(final Class<?> targetClass, final String methodName, final Class<?>... parameterTypes) {
		try {
			return targetClass.getDeclaredMethod(methodName, parameterTypes);
		} catch (final NoSuchMethodException e) {
			try {
				return targetClass.getMethod(methodName, parameterTypes);
			} catch (final NoSuchMethodException ignore) {
				//
			}

			if (!targetClass.getSuperclass().equals(Object.class)) {
				return getMethod(targetClass.getSuperclass(), methodName, parameterTypes);
			}
			throw new IllegalArgumentException(e);
		}
	}

	public static Method getDeclaredMethodOrNull(final Class<?> targetClass, final String methodName, final Class<?>... parameterTypes) {
		try {
			return targetClass.getDeclaredMethod(methodName, parameterTypes);
		} catch (final NoSuchMethodException e) {
			return null;
		}
	}

	@Nullable
	public static <U> U invoke(final Method meth, final Object obj, final Object... args) {
		try {
			return (U) meth.invoke(obj, args);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new IllegalArgumentException(e);
		}

	}

}
