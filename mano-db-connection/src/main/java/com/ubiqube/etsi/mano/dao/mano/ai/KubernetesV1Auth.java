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
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.dao.mano.ai;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ubiqube.etsi.mano.dao.mano.AccessInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@NoArgsConstructor
@SuperBuilder
public class KubernetesV1Auth extends AccessInfo {

	private static final long serialVersionUID = 1L;

	@Column(length = 5000)
	@JsonProperty("client-certificate-data")
	private String clientCertificateData;

	@Column(length = 5000)
	@JsonProperty("client-key-data")
	private String clientKeyData;

}
