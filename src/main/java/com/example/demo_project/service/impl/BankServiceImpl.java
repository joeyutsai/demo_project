package com.example.demo_project.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.OrgCompanyId;
import com.example.demo_project.entity.Person;
import com.example.demo_project.entity.Widget;
import com.example.demo_project.repository.BankDao;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankRes;

@Service
public class BankServiceImpl implements BankService {
//	// * START Homework_1024
	@Autowired
	private BankDao bankDao;

	// 存款，執行後回傳帳號、餘額、訊息。防呆：1. 帳號不得為 null或空 2. 存入金額不能小於0
	@Override
	public BankRes depositRes(String account, int depositAmount) {

		// When depositAmount is negative, set a response to user.
		if (depositAmount < 0) {
			BankRes bankRes = new BankRes();
			bankRes.setMessage("ERROR. DepositAmount is negative.");
			return bankRes;
		}

		// When account is null or empty, set a response to user.
		if (!StringUtils.hasText(account)) {
			BankRes bankRes = new BankRes();
			bankRes.setMessage("ERROR. Account is empty.");
			return bankRes;
		}

		// update amount
		Optional<Bank> bankOp = bankDao.findById(account);
		if (bankOp.isPresent()) { // True: The account is in the data base.

			// get amount from data base and depositAmount
			Bank bankUpdate = bankOp.get();
			bankUpdate.setAmount(bankUpdate.getAmount() + depositAmount);

			// update to data base
			bankDao.save(bankUpdate);

			// set response to user
			BankRes bankRes = new BankRes(bankUpdate.getAccount(), bankUpdate.getAmount());
			bankRes.setMessage("Deposit Successfully." + " DepositAmount: $" + depositAmount + " ACCOUNT: "
					+ bankUpdate.getAccount() + " AMOUNT: $" + bankUpdate.getAmount());
			return bankRes;
		}
		return new BankRes();
	}

	// 建立帳號，餘額預設為0。防呆：無法建立相同帳號。
	@Override
	public Bank creatAccount(String account) {
		return bankDao.save(new Bank(account, 0));
	}

	// 取得餘額，執行後回傳帳號、餘額、訊息。
	@Override
	public Bank getAmount(String account) {
		return bankDao.findById(account).orElse(new Bank());
	}

	// 提款，執行後回傳帳號、餘額、訊息。防呆：1. 帳號不得為 null 或空 2. 提款金額不能小於0或大於存款金額
	@Override
	public Bank withdraw(String account, int withdrawAmount) {
		Optional<Bank> bankOp = bankDao.findById(account);

		// update amount
		if (bankOp.isPresent()) {
			Bank bank = bankOp.get();
			bank.setAmount(bank.getAmount() - withdrawAmount);
			Bank renewBank = bankDao.save(bank);
			return renewBank;
		}
		return new Bank();

	}

	@Transactional
	@Override
	public void deleteAccount(String account) throws RuntimeException {
		bankDao.deleteById(account);
		System.out.println("Delete account success");
		throw new RuntimeException("Create account Error!!");
	}

//	@Transactional
	@Override
	public void deleteByName(String name) {
		bankDao.deleteByName(name);
//		System.out.println("Delete account success");
	}

}
