/**
 * This copy of Woodstox XML processor is licensed under the
 * Apache (Software) License, version 2.0 ("the License").
 * See the License for details about distribution rights, and the
 * specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing Woodstox, in file "ASL2.0", under the same directory
 * as this file.
 */
package com.ubiqube.etsi.mano.dao.audit;

import java.time.OffsetDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@SuppressWarnings("static-method")
public class AuditListener {
	@PrePersist
	public void setCreatedOn(final Auditable auditable) {
		Audit audit = auditable.getAudit();

		if (audit == null) {
			audit = new Audit();
			auditable.setAudit(audit);
		}

		audit.setCreatedOn(OffsetDateTime.now());
	}

	@PreUpdate
	public void setUpdatedOn(final Auditable auditable) {
		final Audit audit = auditable.getAudit();

		audit.setUpdatedOn(OffsetDateTime.now());
	}
}
