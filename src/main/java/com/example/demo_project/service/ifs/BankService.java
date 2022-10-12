package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;

public interface BankService {
	public void getAmount(Bank bank);
	public void deposit(Bank bank, int depositAmount);
	public void withdraw(Bank bank, int withdrawAmount);
}
