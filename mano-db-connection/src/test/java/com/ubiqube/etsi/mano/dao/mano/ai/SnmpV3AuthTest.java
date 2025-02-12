package com.ubiqube.etsi.mano.dao.mano.ai;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SnmpV3AuthTest {

	@Test
	void test() {
		SnmpV3Auth obj = new SnmpV3Auth(null, null, null, null, null, null);
		assertNotNull(obj);
	}

}
