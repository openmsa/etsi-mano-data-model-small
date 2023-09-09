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
package com.ubiqube.etsi.mano.dao.mano.vim.k8s;

/**
 *
 * @author Olivier Vignaud {@literal <ovi@ubiqube.com>}
 *
 */
public enum StatusType {
	CREATE_IN_PROGRESS,
	CREATE_FAILED,
	CREATE_COMPLETE,
	UPDATE_IN_PROGRESS,
	UPDATE_FAILED,
	UPDATE_COMPLETE,
	DELETE_IN_PROGRESS,
	DELETE_FAILED,
	DELETE_COMPLETE,
	RESUME_COMPLETE,
	RESUME_FAILED,
	RESTORE_COMPLETE,
	ROLLBACK_IN_PROGRESS,
	ROLLBACK_FAILED,
	ROLLBACK_COMPLETE,
	SNAPSHOT_COMPLETE,
	CHECK_COMPLETE,
	ADOPT_COMPLETE;

}
