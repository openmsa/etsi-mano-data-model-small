/**
 *     Copyright (C) 2019-2024 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
package com.ubiqube.etsi.mano.dao.mano.ai;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

/**
 * The authentication credentials for certificate-based authentication.
 */
@Data
@Embeddable
public class CertificateAuthInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Kubernetes client certificate data in PEM format.
	 */
	private String clientCertificate;
	/**
	 * Kubernetes client certificate key data in PEM format.
	 */
	private String clientCertificateKey;
}
