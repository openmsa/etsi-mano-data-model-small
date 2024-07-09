package com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ClusterOptionVersion implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;

	private String module;

	private String version;
}
