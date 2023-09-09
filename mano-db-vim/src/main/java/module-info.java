/**
 * This copy of Woodstox XML processor is licensed under the Apache (Software)
 * License, version 2.0 ("the License"). See the License for details about
 * distribution rights, and the specific rights regarding derivate works.
 *
 * You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package containing
 * Woodstox, in file "ASL2.0", under the same directory as this file.
 */
module com.ubiqube.etsi.mano.dao.mano.vim {
	exports com.ubiqube.etsi.mano.dao.mano.vim;

	requires transitive com.ubiqube.etsi.mano.dao.audit;
	requires transitive com.ubiqube.etsi.mano.service.auth.model;
	requires com.ubiqube.etsi.mano.dao.rfc7807;
	requires com.ubiqube.etsi.mano.dao.subscription;
	requires com.ubiqube.etsi.mano.utils;
	requires com.ubiqube.etsi.mano.dao.mano.version;
	requires com.ubiqube.etsi.mano.dao.base;
	requires lombok;
	requires jakarta.annotation;
	requires jakarta.persistence;
	requires com.fasterxml.jackson.annotation;
	requires org.hibernate.search.mapper.pojo;
}