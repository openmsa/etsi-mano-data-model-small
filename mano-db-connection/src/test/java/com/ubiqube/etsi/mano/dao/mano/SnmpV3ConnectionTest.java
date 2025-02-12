package com.ubiqube.etsi.mano.dao.mano;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SnmpV3ConnectionTest {

	@Test
	void test() {
		SnmpV3Connection snmpV3Connection = new SnmpV3Connection();
		assertNotNull(snmpV3Connection);
	}

}
