package com.example.demo_project.vo;

public class BankRes {
	

	private String acount;
	
	private int amount;
	
	private String message;

	public BankRes() {

	}
	
	public BankRes(String acount, int amount) {
		this.setAcount(acount);
		this.setAmount(amount);
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
