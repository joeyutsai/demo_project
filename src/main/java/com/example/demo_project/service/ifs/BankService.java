package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.vo.BankDepositRes;
import com.example.demo_project.vo.BankRes;

public interface BankService {
	public void getBankAmount(Bank bank);
	
	public Bank getAmount(String account);

	public Bank deposit(String account,int depositAmount);
	
	public BankRes withdraw(String account, int withdrawAmount);
}
