/**
 * Copyright (C) 2019-2025 Ubiqube.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package com.ubiqube.etsi.mano.dao.rfc7807;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.function.UnaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubiqube.etsi.mano.utils.UriConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;

@Embeddable
public class FailureDetails implements Serializable {

	private static final Logger LOG = LoggerFactory.getLogger(FailureDetails.class);

	/** Serial. */
	private static final long serialVersionUID = 1L;

	private URI type;

	private String title;

	@Column(nullable = true)
	private Long status;

	@Column(length = 500)
	private String detail;

	@Convert(converter = UriConverter.class)
	private URI instance;

	private static final UnaryOperator<String> CUT = text -> {
		if (null == text) {
			return null;
		}
		return text.codePoints()
				.limit(500)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	};

	public FailureDetails() {
		// Nothing.
	}

	public FailureDetails(final long _status, final String _detail) {
		try {
			instance = URI.create("http//" + InetAddress.getLocalHost().getCanonicalHostName());
		} catch (final UnknownHostException e) {
			LOG.warn("", e);
		}
		status = _status;
		detail = CUT.apply(_detail);
	}

	public URI getType() {
		return type;
	}

	public void setType(final URI type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(final Long status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(final String detail) {
		this.detail = CUT.apply(detail);
	}

	public URI getInstance() {
		return instance;
	}

	public void setInstance(final URI instance) {
		this.instance = instance;
	}

	@Override
	public String toString() {
		return "status: " + status + ", detail: " + detail;
	}
}
