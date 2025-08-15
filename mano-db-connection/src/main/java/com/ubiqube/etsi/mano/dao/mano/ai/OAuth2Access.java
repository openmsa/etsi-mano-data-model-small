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

import java.util.List;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.mano.AccessInfo;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity(name = "oauth2access")
@NoArgsConstructor
@SuperBuilder
public class OAuth2Access extends AccessInfo {
	private static final long serialVersionUID = 1L;
	private String accessTokenUrl;
	private String grantType;
	private String clientId;
	private String password;
	@ElementCollection
	private List<String> scopes;

	public OAuth2Access(final UUID id, final String accessTokenUrl, final String grantType, final String clientId, final String password, final List<String> scopes) {
		super(id);
		this.accessTokenUrl = accessTokenUrl;
		this.grantType = grantType;
		this.clientId = clientId;
		this.password = password;
		this.scopes = scopes;
	}

}
