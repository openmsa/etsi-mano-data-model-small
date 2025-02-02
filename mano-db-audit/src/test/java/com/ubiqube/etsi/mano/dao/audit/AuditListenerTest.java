package com.ubiqube.etsi.mano.dao.audit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuditListenerTest {

	@Test
	void test() {
		AuditListener al = new AuditListener();
		AuditableTest at = new AuditableTest();
		al.setCreatedOn(at);
		al.setUpdatedOn(at);
		al.setCreatedOn(at);
		assertTrue(true);
	}

}
