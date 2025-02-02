package com.ubiqube.etsi.mano.service.auth;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.ubiqube.etsi.mano.dao.test.ModelTest;

class ReflectionTest {
	@Test
	void testName() {
		ModelTest testModel = new ModelTest("com.ubiqube.etsi.mano.service.auth.model");
		testModel.test001();
		assertTrue(true);
	}
}
