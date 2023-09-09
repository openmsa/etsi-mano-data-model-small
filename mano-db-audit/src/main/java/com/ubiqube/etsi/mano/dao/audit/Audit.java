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

import java.io.Serializable;
import java.time.OffsetDateTime;

import jakarta.persistence.Embeddable;

import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public class Audit implements Serializable {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	private OffsetDateTime createdOn;

	@LastModifiedDate
	private OffsetDateTime updatedOn;

	public OffsetDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(final OffsetDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public OffsetDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(final OffsetDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}
