package com.ubiqube.etsi.mano.dao.mano.vim;

import com.ubiqube.etsi.mano.dao.mano.ai.KeystoneAuthV3;
import com.ubiqube.etsi.mano.dao.mano.ii.OpenstackV3InterfaceInfo;

import lombok.Data;

@Data
public class OpenStakVimConnection extends VimConnectionInformation<OpenstackV3InterfaceInfo, KeystoneAuthV3> {
	private static final long serialVersionUID = 1L;

}
