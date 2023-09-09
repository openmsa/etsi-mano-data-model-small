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
package com.ubiqube.etsi.mano.dao.subscription;

import jakarta.annotation.Nonnull;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public enum SubscriptionType {
	VNF("VNF"),
	NSD("NSD"),
	ALARM("ALARM"),
	NSLCM("NSLCM"),
	VNFFM("VNFFM"),
	VNFLCM("VNFLCM"),
	VNFPM("VNFPM"),
	VNFIND("VNFIND"),
	VRQAN("VRQAN"),
	MEOPKG("MEOPKG"),
	NSDVNF("NSDVNF"),
	NSPM("NSPM"),
	NSFM("NSFM"),
	;

	private String value;

	SubscriptionType(final String string) {
		value = string;
	}

	@Nonnull
	@Override
	public String toString() {
		return value;
	}
}
