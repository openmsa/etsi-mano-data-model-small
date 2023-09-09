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
public class L2Data implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private String name;

	private Boolean vlanTransparent = Boolean.FALSE;

	private String networkType;

	private Integer mtu;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Boolean getVlanTransparent() {
		return vlanTransparent;
	}

	public void setVlanTransparent(final Boolean vlanTransparent) {
		this.vlanTransparent = vlanTransparent;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(final String networkType) {
		this.networkType = networkType;
	}

	public Integer getMtu() {
		return mtu;
	}

	public void setMtu(final Integer mtu) {
		this.mtu = mtu;
	}

}
