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
package com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

import java.io.Serializable;

import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

/**
 * Information missing from Sol001/ osContainer
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Getter
@Setter
@Embeddable
public class CnfInformations implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private String masterFlavorId;

	@Nonnull
	private String clusterTemplate;

	@Nullable
	private String dnsServer;

	@Nullable
	private String keyPair;

	@Nullable
	private String networkDriver = "flannel";

	@Nullable
	private VmServerType serverType = VmServerType.VM;

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}

}
