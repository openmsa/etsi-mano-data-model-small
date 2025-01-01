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
package com.ubiqube.etsi.mano.dao.mano.ai;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * The authentication credentials for Open ID-based authentication.
 */
@Data
@Embeddable
public class OidAuthInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * The username to use for access.
	 */
	private String username;
	/**
	 * The password for the username for access. Required for input, not returned on
	 * output.
	 */
	private String password;
	/**
	 * An ID which identifies an client application to use for access.
	 */
	private String clientId;
	/**
	 * The secret for the clientId for access. Required for input, not returned on
	 * output.
	 */
	private String clientSecret;
	/**
	 * CA certificate data of the Open ID API server in PEM format.
	 */
	private String remoteServerCertificate;
	/**
	 * Certificate verification for the remote server can be skipped by setting this
	 * field to true.
	 */
	private boolean skipCertificateVerification;
}
