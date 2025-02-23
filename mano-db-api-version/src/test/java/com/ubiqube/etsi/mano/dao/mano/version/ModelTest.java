package com.ubiqube.etsi.mano.dao.mano.version;

import org.junit.jupiter.api.Test;

import com.ubiqube.etsi.mano.dao.test.ModelTest;

class ReflectionTest {
	@Test
	void testName() {
		ModelTest test = new ModelTest("com.ubiqube.etsi.mano.dao.mano.version");
		test.test001();
	}
}
