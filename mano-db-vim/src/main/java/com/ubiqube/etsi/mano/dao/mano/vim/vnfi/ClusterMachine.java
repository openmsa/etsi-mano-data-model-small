package com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClusterMachine implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Flavor ID, you can specify flavorId or flavor name.
	 */
	private String flavorId;
	/**
	 * Flavor name, you can specify flavorId or flavor name.
	 */
	private String flavor;
	/**
	 * Minimum number of instance.
	 */
	private int minNumberInstance = 1;
	/**
	 * Image deployment name.
	 */
	private String image;
}
