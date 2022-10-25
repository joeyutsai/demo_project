package com.example.demo_project.vo;

import com.example.demo_project.entity.Bank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankReq {
	
	@JsonProperty("account")
	private String account;

	public BankReq() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
