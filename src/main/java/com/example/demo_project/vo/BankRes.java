package com.example.demo_project.vo;

import com.example.demo_project.entity.Bank;
import com.fasterxml.jackson.annotation.JsonInclude;

public class BankRes {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	
	private String acount;
	private int amount;
	private String message;

	public BankRes() {

	}

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
