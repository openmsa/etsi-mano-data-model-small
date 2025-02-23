/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mockStatic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;
import com.ubiqube.etsi.mano.dao.test.ModelTest;

class ReflectionTest {

	@Test
	void testName() {
		ModelTest testModel = new ModelTest("com.ubiqube.etsi.mano.dao.rfc7807");
		testModel.test001();
	}

	@Test
	void testName2() {
		FailureDetails fd = new FailureDetails(0, null);
		assertNotNull(fd);
	}

	@Test
	void testName3() {
		try (MockedStatic<InetAddress> mockUri = mockStatic(InetAddress.class)) {
			mockUri.when(InetAddress::getLocalHost).thenThrow(UnknownHostException.class);
			FailureDetails fd = new FailureDetails(0, null);
			assertNotNull(fd);
		}
	}
}
