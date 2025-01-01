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
package com.ubiqube.etsi.mano.dao.mano;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InterfaceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String endpoint;

	@JsonProperty("non-strict-ssl")
	private boolean nonStrictSsl;

	@JsonProperty("nat-host")
	private String natHost;

	/**
	 * Connection timeout in millisecondes.
	 */
	@JsonProperty("connection-timeout")
	private int connectionTimeout = 5_000;

	/**
	 * Read timeout in millisecondes.
	 */
	@JsonProperty("read-timeout")
	private int readTimeout = 5_000;

	/**
	 * Retry on failure.
	 */
	private int retry = 5;

	@JsonProperty("interface")
	private String iface;

	@JsonProperty("region-name")
	private String regionName;

	@JsonProperty("sdn-endpoint")
	private String sdnEndpoint;
}
