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
module com.ubiqube.etsi.mano.dao.mano.vim {
	exports com.ubiqube.etsi.mano.dao.mano.vim;
	exports com.ubiqube.etsi.mano.dao.mano.vim.dto;
	exports com.ubiqube.etsi.mano.dao.mano.vim.k8s;
	exports com.ubiqube.etsi.mano.dao.mano.vim.vnffg;
	exports com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

	requires transitive com.ubiqube.etsi.mano.dao.audit;
	requires transitive com.ubiqube.etsi.mano.service.auth.model;
	requires com.ubiqube.etsi.mano.dao.mano;
	requires com.ubiqube.etsi.mano.dao.rfc7807;
	requires com.ubiqube.etsi.mano.dao.subscription;
	requires com.ubiqube.etsi.mano.utils;
	requires com.ubiqube.etsi.mano.dao.mano.version;
	requires com.ubiqube.etsi.mano.dao.base;
	requires org.hibernate.orm.core;
	requires org.jspecify;
	requires org.mapstruct;
	requires lombok;
	requires jakarta.annotation;
	requires jakarta.persistence;
	requires jakarta.validation;
	requires java.compiler;
	requires com.fasterxml.jackson.annotation;
}