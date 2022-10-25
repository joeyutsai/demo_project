package com.example.demo_project.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrgCompanyId implements Serializable {

	public String orgId;

	public String companyId;

	public OrgCompanyId() {

	}

	public OrgCompanyId(String orgId, String companyId) {
		this.setOrgId(orgId);
		this.setCompanyId(companyId);
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
