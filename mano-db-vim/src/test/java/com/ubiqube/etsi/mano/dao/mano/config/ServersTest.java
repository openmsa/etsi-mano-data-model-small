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

import com.ubiqube.etsi.mano.service.auth.model.AuthentificationInformations;

import uk.co.jemos.podam.api.PodamFactoryImpl;

class ServersTest {

	private PodamFactoryImpl podam;

	@BeforeEach
	void setUp() {
		podam = new PodamFactoryImpl();
		podam.getStrategy().setDefaultNumberOfCollectionElements(1);
	}

	@Test
	void test() {
		Servers servers = podam.manufacturePojo(Servers.class);
		assertNotNull(servers);
	}

	@Test
	void testBuilder() {
		Servers servers = Servers.builder()
				.url(URI.create("http://localhost:8080"))
				.build();
		assertNotNull(servers);
	}

	@Test
	void testBuilderCtor() {
		AuthentificationInformations auth = new AuthentificationInformations();
		Servers servers = new Servers(auth, URI.create("http://localhost:8080"));
		assertNotNull(servers);
		servers.addVersion(null);
		assertNotNull(servers.toString());
	}

}
