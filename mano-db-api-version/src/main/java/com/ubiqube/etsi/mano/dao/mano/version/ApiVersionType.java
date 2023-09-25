/**
 *     Copyright (C) 2019-2023 Ubiqube.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */
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
package com.ubiqube.etsi.mano.dao.mano.version;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public enum ApiVersionType {
	SOL003_VNFPKGM("vnfpkgm"),
	SOL005_VNFPKGM("vnfpkgm"),
	SOL003_VNFSNAPSHOTPKGM("vnfsnapshotpkgm"),
	SOL003_GRANT("grant"),
	SOL002_VNFPM("vnfpm"),
	SOL003_VNFPM("vnfpm"),
	SOL002_VNFLCM("vnflcm"),
	SOL003_VNFLCM("vnflcm"),
	SOL002_VNFIND("vnfind"),
	SOL003_VNFIND("vnfind"),
	SOL002_VNFFM("vnffm"),
	SOL003_VNFFM("vnffm"),
	SOL003_VRQAN("vrqan"),
	SOL005_NSD("nsd"),
	SOL005_NSFM("nsfm"),
	SOL005_NSLCM("nslcm"),
	SOL005_NSPM("nspm"),
	SOL002_VNFCONFIG("vnfconfig");

	private String value;

	ApiVersionType(final String string) {
		value = string;
	}

	@Override
	public String toString() {
		return value;
	}

}
