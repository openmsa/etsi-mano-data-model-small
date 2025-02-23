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
package com.ubiqube.etsi.mano.dao.mano.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactoryImpl;

class LocalAuthTest {

	private PodamFactoryImpl podam;

	@BeforeEach
	void setUp() {
		podam = new PodamFactoryImpl();
		podam.getStrategy().setDefaultNumberOfCollectionElements(1);
	}

	@Test
	void test() {
		LocalAuth localAuth = podam.manufacturePojo(LocalAuth.class);
		assertNotNull(localAuth);
		assertNotNull(localAuth.toString());
	}

	@Test
	void testBuilder() {
		LocalAuth localAuth = LocalAuth.builder()
				.tokenEndpoint(URI.create("http://localhost:8080"))
				.build();
		assertNotNull(localAuth);
	}
}
