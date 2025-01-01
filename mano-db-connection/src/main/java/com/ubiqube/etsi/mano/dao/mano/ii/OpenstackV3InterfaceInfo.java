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
package com.ubiqube.etsi.mano.dao.mano.ii;

import java.util.List;

import com.ubiqube.etsi.mano.dao.mano.InterfaceInfo;

import org.jspecify.annotations.Nullable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class OpenstackV3InterfaceInfo extends InterfaceInfo {

	private static final long serialVersionUID = 1L;
	/**
	 * A collection of base64 encoded certificates to be trusted in relation to the
	 * endpoint.
	 */
	@Nullable
	@ElementCollection
	private List<String> trustedCertificates;
	/**
	 * Certificate hostname check for the endpoint can be skipped by setting this
	 * field to true.
	 */
	private boolean skipCertificateHostnameCheck;
	/**
	 * Certificate verification for the endpoint can be skipped by setting this
	 * field to true.
	 */
	@Nullable
	private String skipCertificateVerification;
}
