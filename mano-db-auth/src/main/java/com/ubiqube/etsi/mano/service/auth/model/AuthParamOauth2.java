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

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AuthParamOauth2 implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;
	private String clientId;
	private String clientSecret;
	private String tokenEndpoint;
	private String o2Username;
	private String o2Password;
	private Boolean o2IgnoreSsl;
	@Enumerated(EnumType.STRING)
	private OAuth2GrantType grantType;
	@Column(length = 5000)
	private String o2AuthTlsCert;

}
