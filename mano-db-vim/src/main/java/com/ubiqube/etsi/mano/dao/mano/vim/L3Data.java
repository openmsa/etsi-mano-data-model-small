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
package com.ubiqube.etsi.mano.dao.mano.vim;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class L3Data implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	/*
	 * XXX Side effect of embedded ? Must be an Object.
	 */
	private Boolean dhcpEnabled;

	private String ipv6AddressMode;

	private String ipVersion;

	private String l3Name;

	private String cidr;

	private String gatewayIp;

	public Boolean isDhcpEnabled() {
		return dhcpEnabled;
	}

	public void setDhcpEnabled(final Boolean dhcpEnabled) {
		this.dhcpEnabled = dhcpEnabled;
	}

	public String getIpv6AddressMode() {
		return ipv6AddressMode;
	}

	public void setIpv6AddressMode(final String ipv6AddressMode) {
		this.ipv6AddressMode = ipv6AddressMode;
	}

	public String getIpVersion() {
		return ipVersion;
	}

	public void setIpVersion(final String ipVersion) {
		this.ipVersion = ipVersion;
	}

	public String getL3Name() {
		return l3Name;
	}

	public void setL3Name(final String l3Name) {
		this.l3Name = l3Name;
	}

	public String getCidr() {
		return cidr;
	}

	public void setCidr(final String cidr) {
		this.cidr = cidr;
	}

	public String getGatewayIp() {
		return gatewayIp;
	}

	public void setGatewayIp(final String gatewayIp) {
		this.gatewayIp = gatewayIp;
	}

}
