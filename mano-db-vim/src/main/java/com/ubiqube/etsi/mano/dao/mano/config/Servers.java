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
package com.ubiqube.etsi.mano.dao.mano.config;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.TenantId;

import com.ubiqube.etsi.mano.dao.audit.Audit;
import com.ubiqube.etsi.mano.dao.audit.AuditListener;
import com.ubiqube.etsi.mano.dao.audit.Auditable;
import com.ubiqube.etsi.mano.dao.mano.version.ApiVersion;
import com.ubiqube.etsi.mano.dao.mano.vim.PlanStatusType;
import com.ubiqube.etsi.mano.dao.rfc7807.FailureDetails;
import com.ubiqube.etsi.mano.dao.subscription.RemoteSubscription;
import com.ubiqube.etsi.mano.dao.subscription.SubscriptionType;
import com.ubiqube.etsi.mano.service.auth.model.AuthentificationInformations;
import com.ubiqube.etsi.mano.service.auth.model.ServerConnection;
import com.ubiqube.etsi.mano.service.auth.model.ServerType;
import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditListener.class)
public class Servers extends ServerConnection implements Auditable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Builder
	public Servers(final UUID id, final String name, final AuthentificationInformations authentification, @Nonnull final URI url, final boolean ignoreSsl, final String tlsCert, @Nullable final String version, @Nullable final ServerType serverType, final long tupleVersion,
			final Set<RemoteSubscription> remoteSubscriptions, final PlanStatusType serverStatus, final SubscriptionType subscriptionType, final Set<String> capabilities,
			final @Nonnull LocalAuth localUser, final String tenantId) {
		super(id, name, authentification, url, ignoreSsl, tlsCert, version, serverType, tupleVersion);
		this.remoteSubscriptions = remoteSubscriptions;
		this.serverStatus = serverStatus;
		this.subscriptionType = subscriptionType;
		this.capabilities = capabilities;
		this.localUser = localUser;
		this.tenantId = tenantId;
	}

	@Enumerated(EnumType.STRING)
	// XXX only on DB@NotNull
	private SubscriptionType subscriptionType;

	@Enumerated(EnumType.STRING)
	private PlanStatusType serverStatus;

	private FailureDetails failureDetails;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> capabilities;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<RemoteSubscription> remoteSubscriptions;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ApiVersion> versions;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@NotNull
	private LocalAuth localUser = new LocalAuth();

	@TenantId
	private String tenantId;

	private Audit audit = new Audit();

	public Servers(final AuthentificationInformations authentication, final @Nonnull URI callbackUri) {
		super(authentication, callbackUri);
	}

	public void addVersion(final ApiVersion version2) {
		if (null == versions) {
			versions = new HashSet<>();
		}
		versions.add(version2);
	}

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}

}
