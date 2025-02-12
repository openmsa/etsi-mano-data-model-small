package com.ubiqube.etsi.mano.dao.mano.ii;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class EtsiK8sAuthTypeTest {

	@Test
	void test() {
		EtsiK8sAuthType e = EtsiK8sAuthType.fromValue("OID");
		assertNotNull(e);
		assertEquals("OID", e.toString());
		e = EtsiK8sAuthType.fromValue(null);
		assertNull(e);
	}

}
