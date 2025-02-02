package com.ubiqube.etsi.mano.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.ubiqube.etsi.mano.dao.test.ModelTest;

public class ReflectionTest {
	@Test
	void testName() {
		ModelTest testModel = new ModelTest("com.ubiqube.etsi.mano.dao.audit");
		testModel.test001();
		assertTrue(true);
	}

}
