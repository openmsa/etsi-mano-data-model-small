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

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class KeystoneAuthV3 extends BasicAccess {
	private static final long serialVersionUID = 1L;

	public KeystoneAuthV3(final UUID id, final String username, final String password, final String userDomain, final String project, final String projectDomain, @NotNull final String region, final String projectId) {
		super(id, username, password);
		this.region = region;
		this.project = project;
		this.projectDomain = projectDomain;
		this.userDomain = userDomain;
		this.projectId = projectId;
	}

	/**
	 * The OpenStack region to use for the VIM connection.
	 */
	@NotNull
	private String region;
	/**
	 * The OpenStack project to use for the VIM connection.
	 */
	@NotNull
	private String project;

	private String projectId;
	/**
	 * The OpenStack project domain to use for the VIM connection.
	 */
	@NotNull
	private String projectDomain;
	/**
	 * The OpenStack user domain to use for the VIM connection.
	 */
	@NotNull
	private String userDomain;
}
