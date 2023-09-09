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
package com.ubiqube.etsi.mano.dao.mano.vim.k8s;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class K8sServers implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	@Id
	private UUID id;

	private UUID vnfInstanceId;

	private String toscaName;

	/**
	 * ca.crt
	 */
	@Column(length = 5000)
	private String caPem;

	/**
	 * User CRT.
	 */
	@Column(length = 5000)
	private String userCrt;

	private String apiAddress;

	/**
	 * Uniq identifier in VIM. (Mainly the cluster ID).
	 */
	private String vimResourceId;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> masterAddresses;

	@Enumerated(EnumType.STRING)
	private StatusType status;
}
