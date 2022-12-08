package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActiveAccountReq {

	private String account;

	@JsonProperty("verify_code")
	private int verifyCode;

	public ActiveAccountReq() {

	}

	public ActiveAccountReq(String account, int verifyCode) {
		this.account = account;
		this.verifyCode = verifyCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(int verifyCode) {
		this.verifyCode = verifyCode;
	}

}
