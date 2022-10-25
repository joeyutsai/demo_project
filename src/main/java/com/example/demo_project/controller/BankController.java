package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankDepositReq;
import com.example.demo_project.vo.BankDepositRes;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;
import com.example.demo_project.vo.BankWithdrawReq;
import com.example.demo_project.vo.BankWithdrawRes;

@RestController
public class BankController {
//	//Homework_1018

	@Autowired
	private BankService bankService;

	@PostMapping(value = "/api/getAmount")
	public BankRes getAmount(@RequestBody BankReq request) {
		BankRes res = new BankRes();
		if (!StringUtils.hasText(request.getAccount())) {
			res.setMessage("Account is empty!!");
			return res;
		}
		Bank bank = bankService.getAmount(request.getAccount());
//		res.setBank(bank);

		return res;
	}

	@PostMapping(value = "/api/deposit") // API
	public BankDepositRes deposit(@RequestBody BankDepositReq depositReq) {
		BankDepositRes res = new BankDepositRes();

		if (!StringUtils.hasText(depositReq.getAccount())) {
			res.setMessage("Account is empty!");
			return res;
		}

		if (depositReq.getAmount() < 0) {
			res.setMessage("Amount is negative!");
			return res;
		}

		Bank bank = bankService.deposit(depositReq.getAccount(), depositReq.getAmount());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("Successful!!");
		return res;
	}
	
	@PostMapping(value = "/api/withdraw") 
	public BankWithdrawRes withdraw(@RequestBody BankWithdrawReq withdrawReq) {
		BankRes result = bankService.withdraw(withdrawReq.getAccount(), withdrawReq.getAmount());
		BankWithdrawRes res = new BankWithdrawRes();
		if (!StringUtils.hasText(withdrawReq.getAccount())) {
			res.setMessage("Account is empty!");
			return res;
		}
		if (withdrawReq.getAmount() < 0 || withdrawReq.getAmount() < 0) {

		}
//		res.setAccount(result.getAccount()); //???
		res.setAmount(result.getAmount());
		res.setMessage(result.getMessage());
		return res;
	}

//	//classroom_1018
//	@Autowired
//	private BankService bankService;
//
//	@PostMapping(value = "/api/getAmount")
//	public BankRes getAmount(@RequestBody BankReq request) {
//		BankRes res = new BankRes();

	// method_1
//		String account = request.getAccount();
//		if (account == null || account.isEmpty() || account == " ") {
//			res.setMessage("Account is empty!!");
//			return res;
//		}

	// method_2
//		if (!StringUtils.hasText(request.getAccount())) {
//			res.setMessage("Account is empty!!");
//			return res;
//		}
//		
	// ==========
//		Bank bank = bankService.getAmount(request.getAccount());
//		res.setAccount(bank.getAccount());
//		res.setAmount(bank.getAmount());
//		res.setMessage("Success");
//		return res;
//	}
}
