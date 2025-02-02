package com.ubiqube.etsi.mano.dao.audit;

public class AuditableTest implements Auditable {

	private Audit audit;

	@Override
	public Audit getAudit() {
		return audit;
	}

	@Override
	public void setAudit(final Audit audit) {
		this.audit = audit;
	}

}
