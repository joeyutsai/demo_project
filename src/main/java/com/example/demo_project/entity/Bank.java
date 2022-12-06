package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {
	@Id
	@Column(name = "account")
	private String account;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "name")
	private String name;

	public Bank() {

	}

	public Bank(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}
	
	public Bank(String account, int amount, String name) {
		this.account = account;
		this.amount = amount;
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
