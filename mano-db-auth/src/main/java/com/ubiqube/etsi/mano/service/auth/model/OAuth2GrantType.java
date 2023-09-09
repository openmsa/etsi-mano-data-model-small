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
package com.ubiqube.etsi.mano.service.auth.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OAuth2GrantType {
	PASSWORD("password"),
	CLIENT_CREDENTIAL("client_credentials");

	private final String value;

	OAuth2GrantType(final String value) {
		this.value = value;
	}

	@JsonValue
	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@JsonCreator
	public static OAuth2GrantType fromValue(final String text) {
		for (final OAuth2GrantType b : OAuth2GrantType.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

}
