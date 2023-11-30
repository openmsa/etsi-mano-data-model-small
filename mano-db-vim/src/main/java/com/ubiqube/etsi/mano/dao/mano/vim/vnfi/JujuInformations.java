package com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

import java.io.Serializable;

import com.ubiqube.etsi.mano.utils.ToStringUtil;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class JujuInformations implements Serializable{	

	private static final long serialVersionUID = 1L;

	private String imageId;
	private String region;	
	private String constraints;	
	private String networkId;
	private String charmName;
	private String appName;
	private String osSeries;

	@Override
	public String toString() {
		return ToStringUtil.toString(this);
	}
}