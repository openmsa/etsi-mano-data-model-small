package com.ubiqube.etsi.mano.dao.mano.vim.dto;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.ubiqube.etsi.mano.dao.mano.ai.KeystoneAuthV3;
import com.ubiqube.etsi.mano.dao.mano.ii.OpenstackV3InterfaceInfo;
import com.ubiqube.etsi.mano.dao.mano.vim.vnfi.CnfInformations;
import com.ubiqube.etsi.mano.dao.mano.vim.vnfi.JujuInformations;
import com.ubiqube.etsi.mano.dao.mano.vim.vnfi.VimCapability;

import lombok.Data;

@Data
public class VimOsKeystone3Connection {
	private UUID id;

	private String vimId;

	private String vimType;

	private CnfInformations cnfInfo;

	private JujuInformations jujuInfo;

	private Map<String, String> extra;
	/**
	 * Capabilities of the vim. Read VimCapabilites Enum to figure out what we can
	 * do.
	 */
	private Set<VimCapability> vimCapabilities;

	private long version;

	private String tenantId;

	private OpenstackV3InterfaceInfo interfaceInfo;

	private KeystoneAuthV3 accessInfo;
}
