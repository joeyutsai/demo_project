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
	@Autowired
	private BankService bankService;
	
	// 存款，執行後回傳帳號、餘額、訊息。防呆：1. 帳號不得為 null或空 2. 存入金額不能小於0
	@PostMapping(value = "/api/depositRes")
	public BankRes depositRes(@RequestBody BankReq req) {
		return bankService.depositRes(req.getAccount(), req.getAmount());
	}

	// 建立帳號，餘額預設為0。防呆：無法建立相同帳號。
	@PostMapping(value = "/api/creatAccount")
	public Bank creatAccount(@RequestBody BankReq req) {
		return bankService.creatAccount(req.getAccount());
	}

	// 取得餘額，執行後回傳帳號、餘額、訊息。
	@PostMapping(value = "/api/getAccount")
	public Bank getAccount(@RequestBody BankReq req) {
		return bankService.getAmount(req.getAccount());

	}
		
	// 提款，執行後回傳帳號、餘額、訊息。防呆：1. 帳號不得為 null 或空 2. 提款金額不能小於0或大於存款金額
	@PostMapping(value = "/api/withdraw")
	public Bank withdraw(@RequestBody BankReq req) {
		return bankService.withdraw(req.getAccount(), req.getAmount());
	}

	// 刪除帳號。
		@PostMapping(value = "/api/deleteAccount")
		public BankRes deleteAccount(@RequestBody BankReq req) {
			bankService.deleteAccount(req.getAccount());
			return new BankRes();
		}
		
		@PostMapping(value = "/api/deleteByName")
		public void deleteByName(@RequestBody BankReq req) {
			bankService.deleteByName(req.getName());
		}
}
