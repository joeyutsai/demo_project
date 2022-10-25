package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@IdClass(value = OrgCompanyId.class)
public class Company {

	@Id
	@Column(name = "org_id")
	public String orgId;

	@Id
	@Column(name = "company_id")
	public String companyId;

	@Column(name = "company_name")
	public String companyName;

	public Company() {

	}
	
	public Company(String orgId, String companyId, String companyName) {
		this.setOrgId(orgId);
		this.setCompanyId(companyId);
		this.setCompanyName(companyName);
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
