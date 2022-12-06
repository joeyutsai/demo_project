package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.vo.BankDepositRes;
import com.example.demo_project.vo.BankRes;

public interface BankService {

	// 建立帳號，餘額預設為0。防呆：無法建立相同帳號。
	public Bank creatAccount(String account);

	// 取得餘額，執行後回傳帳號、餘額、訊息。
	public Bank getAmount(String account);

	// 存款，執行後回傳帳號、餘額、訊息。防呆：1. 帳號不得為 null或空 2. 存入金額不能小於0
	public BankRes depositRes(String account, int depositAmount);

	// 提款，執行後回傳帳號、餘額、訊息。防呆：1. 帳號不得為 null 或空 2. 提款金額不能小於0或大於存款金額
	public Bank withdraw(String account, int withdrawAmount);
	
	// 刪除帳號。
	public void deleteAccount(String account) throws RuntimeException;
	public void deleteByName(String name);


}
