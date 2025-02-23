package com.ubiqube.etsi.mano.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactoryImpl;

class ToStringUtilTest {

	private PodamFactoryImpl podam;

	@BeforeEach
	void setUp() {
		podam = new PodamFactoryImpl();
		podam.getStrategy().setDefaultNumberOfCollectionElements(1);
	}

	@Test
	void test() {
		Obj o = podam.manufacturePojo(Obj.class);
		String res = ToStringUtil.toString(o);
		assertNotNull(res);
		o = new Obj();
		o.setList(List.of());
		res = ToStringUtil.toString(o);
		assertNotNull(res);
	}

}
