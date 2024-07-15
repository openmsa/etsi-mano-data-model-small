package com.ubiqube.etsi.mano.dao.mano.vim.vnfi;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ClusterMachine implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private UUID id;
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
