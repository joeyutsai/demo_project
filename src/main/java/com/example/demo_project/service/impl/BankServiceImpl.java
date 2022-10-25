package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankRes;

@Service
public class BankServiceImpl implements BankService {

	@Override
	public void getBankAmount(Bank bank) {
		System.out.println("ACCOUNT: " + bank.getAccount() + "\nAMOUNT: $" + bank.getAmount());
	}

	@Override
	public Bank deposit(String account, int depositeAmount) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(bank.getAmount() + depositeAmount);
		return bank;
	}

	@Override
	public BankRes withdraw(String account, int withdrawAmount) {
		int initAmount = 500;
		BankRes res = new BankRes();
		if (withdrawAmount < 0) {
			res.setMessage("Amount is negative!");
			return res;
		}
		if (withdrawAmount > initAmount) {
			res.setMessage("withdrawAmount is larger than negative!");
			return res;
		}
		res.setAcount(account);
		res.setAmount(initAmount + withdrawAmount);
		res.setMessage("Successful!");
		return res;
	}

//	@Override
//	public void deposit(Bank bank, int depositAmount) {
//		bank.setAmount(bank.getAmount() + depositAmount);
//		System.out.println("== " + bank.getAccount() + " DEPOSIT ==");
//		System.out.println("Deposit money: "+ depositAmount);		
//		System.out.println("NOW AMOUNT: $" + bank.getAmount());	
//	}

//	@Override
//	public void withdraw(Bank bank, int withdrawAmount) {
//		System.out.println("== " + bank.getAccount() + " WITHDRAW ==");		
//		System.out.println("Withdraw money: $"+ withdrawAmount);		
//		if ((bank.getAmount() - withdrawAmount) < 0) {
//			System.out.println("You don't have enough money. You only have: $" + bank.getAmount());		
//
//		} else {
//			bank.setAmount(bank.getAmount() - withdrawAmount);
//			System.out.println("NOW AMOUNT: $" + bank.getAmount());	
//		}
//	}

	@Override
	public Bank getAmount(String account) {
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(1000);
		return bank;
	}

}
