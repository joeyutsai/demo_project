package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Override
	public void getAmount(Bank bank) {
		System.out.println("ACCOUNT: "+ bank.getAccount() + "\nAMOUNT: $" + bank.getAmount());		
	}

	@Override
	public void deposit(Bank bank, int depositAmount) {
		bank.setAmount(bank.getAmount() + depositAmount);
		System.out.println("== " + bank.getAccount() + " DEPOSIT ==");
		System.out.println("Deposit money: "+ depositAmount);		
		System.out.println("NOW AMOUNT: $" + bank.getAmount());		

	}

	@Override
	public void withdraw(Bank bank, int withdrawAmount) {
		System.out.println("== " + bank.getAccount() + " WITHDRAW ==");		
		System.out.println("Withdraw money: $"+ withdrawAmount);		
		if ((bank.getAmount() - withdrawAmount) < 0) {
			System.out.println("You don't have enough money. You only have: $" + bank.getAmount());		

		} else {
			bank.setAmount(bank.getAmount() - withdrawAmount);
			System.out.println("NOW AMOUNT: $" + bank.getAmount());	
		}
		
	}

}
