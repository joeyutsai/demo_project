package com.example.demo_project.vo;

import java.util.List;
import java.util.Set;

public class AddRoleSetReq {
	private String account;
	
	private Set<String> roleSet;
	
	public AddRoleSetReq() {
		
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Set<String> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<String> roleSet) {
		this.roleSet = roleSet;
	}


	
	
}
