package com.ubiqube.etsi.mano.dao.mano.vim.mapping;

import org.mapstruct.Mapper;

import com.ubiqube.etsi.mano.dao.mano.AccessInfo;
import com.ubiqube.etsi.mano.dao.mano.InterfaceInfo;
import com.ubiqube.etsi.mano.dao.mano.ai.KeystoneAuthV3;
import com.ubiqube.etsi.mano.dao.mano.ii.OpenstackV3InterfaceInfo;
import com.ubiqube.etsi.mano.dao.mano.vim.OpenStakVimConnection;
import com.ubiqube.etsi.mano.dao.mano.vim.VimConnectionInformation;

@Mapper
public interface OsKeyStoneV3Mapping {

	default OpenStakVimConnection map(final VimConnectionInformation o) {
		if (o == null) {
			return null;
		}
		final OpenStakVimConnection ret = new OpenStakVimConnection();
		ret.setCnfInfo(o.getCnfInfo());
		ret.setExtra(o.getExtra());
		ret.setId(o.getId());
		ret.setJujuInfo(o.getJujuInfo());
		ret.setTenantId(o.getTenantId());
		ret.setVersion(o.getVersion());
		ret.setVimCapabilities(o.getVimCapabilities());
		ret.setVimId(o.getVimId());
		ret.setVimType(o.getVimType());
		final InterfaceInfo ii = o.getInterfaceInfo();
		if (ii instanceof final OpenstackV3InterfaceInfo oii) {
			ret.setInterfaceInfo(oii);
		} else {
			ret.setInterfaceInfo(map(ii));
		}
		final AccessInfo ai = o.getAccessInfo();
		if (!(ai instanceof final KeystoneAuthV3 ka3)) {
			throw new UnsupportedOperationException("Unknwon AccessInfo class: " + ai.getClass().getName());
		}
		ret.setAccessInfo(ka3);
		return ret;
	}

	OpenstackV3InterfaceInfo map(InterfaceInfo ii);
}
