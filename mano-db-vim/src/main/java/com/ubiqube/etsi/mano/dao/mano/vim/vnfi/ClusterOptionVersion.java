package com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class ClusterOptionVersion implements Serializable {
	/** Serial. */
	private static final long serialVersionUID = 1L;
	/**
	 * Vim ID, same as vimId in {@link} VimConnectionInformation}.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private UUID id;

	private String module;

	private String version;
}
