package com.ubiqube.etsi.mano.dao.mano.ai;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class OAuth2AccessTest {

	@Test
	void test() {
		OAuth2Access obj = new OAuth2Access(null, null, null, null, null, null);
		assertNotNull(obj);
	}

}
