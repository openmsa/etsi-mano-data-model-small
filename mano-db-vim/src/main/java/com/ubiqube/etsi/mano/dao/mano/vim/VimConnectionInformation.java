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
package com.ubiqube.etsi.mano.dao.mano.vim;

import java.util.Set;

import org.hibernate.annotations.TenantId;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.mano.AccessInfo;
import com.ubiqube.etsi.mano.dao.mano.Connection;
import com.ubiqube.etsi.mano.dao.mano.InterfaceInfo;
import com.ubiqube.etsi.mano.dao.mano.vim.vnfi.CnfInformations;
import com.ubiqube.etsi.mano.dao.mano.vim.vnfi.JujuInformations;
import com.ubiqube.etsi.mano.dao.mano.vim.vnfi.VimCapability;
import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditListener.class)
public class VimConnectionInformation<I extends InterfaceInfo, A extends AccessInfo> extends Connection<I, A> implements Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(unique = true)
	private String vimId;

	@NotNull
	private String vimType;

	@Embedded
	private CnfInformations cnfInfo;

	@Embedded
	private JujuInformations jujuInfo;
	/**
	 * Capabilities of the vim. Read VimCapabilites Enum to figure out what we can
	 * do.
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<VimCapability> vimCapabilities;

	// XXX: There is a bug when activated in vnf instantiate. When saving a
	// vnfBlueprint.
	// @Version
	private long version;

	@TenantId
	private String tenantId;

	private Audit audit;

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}

}
