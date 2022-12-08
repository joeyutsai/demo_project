package com.example.demo_project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.ActiveAccountReq;
import com.example.demo_project.vo.AddRoleListReq;
import com.example.demo_project.vo.AddRoleSetReq;
import com.example.demo_project.vo.LoginInfo;
import com.example.demo_project.vo.RegisterReq;
import com.example.demo_project.vo.RegisterRes;

@RestController
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@PostMapping(value = "/api/active_account2")
	public RegisterRes activeAccount2(@RequestBody ActiveAccountReq req, HttpSession httpSession) {

		Object sessionUserVerifyCode = httpSession.getAttribute("user_verify_code");

		if (!StringUtils.hasText(req.getAccount()) || req.getVerifyCode() == 0) {
			return new RegisterRes("Please enter account or verify code.");
		}

		if (sessionUserVerifyCode == null) {
			return new RegisterRes("HTTP Session user verify code is empty.");
		} else if (req.getVerifyCode() == (int) sessionUserVerifyCode) {
			registerService.activeAccount(req.getAccount());
			return new RegisterRes("Successfully. Verify code is correct. Account actived.", req.getVerifyCode());
		}
		
		return new RegisterRes("Error. Verify code is not correct.");
	}

	@PostMapping(value = "/api/add_role_set")
	public RegisterRes addRoleSet(@RequestBody AddRoleSetReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		if (req.getRoleSet().isEmpty()) {
			return new RegisterRes(RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());
		}
//		if(CollectionUtils.is) {
//			
//		}

		return registerService.addRoleSet(req.getAccount(), req.getRoleSet());

	}

	@PostMapping(value = "/api/add_role_list")
	public RegisterRes addRoleList(@RequestBody AddRoleListReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		if (req.getRoleList().isEmpty()) {
			return new RegisterRes(RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());
		}

		return registerService.addRole(req.getAccount(), req.getRoleList());

	}

	@PostMapping(value = "/api/register")
	public RegisterRes register(@RequestBody RegisterReq req, HttpSession httpSession) {

		RegisterRes checkResult = checkParam(req);
		if (checkResult != null) {
			return checkResult;
		}

		Register reg = registerService.register(req.getAccount(), req.getPwd(), req.getName(), req.getAge(),
				req.getCity());

		if (reg == null) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
		}

		// Practice1208: produce verify code and add verify code into httpSession
		// START

		// produce random digits (less then four digits)
		int verifyCode = 0;

		while (verifyCode == 0) {
			verifyCode = produceRandomVerifyCode();
		}

		// add verify code into httpSession
		httpSession.setAttribute("user_verify_code", verifyCode);

		// add user account into httpSession
		httpSession.setAttribute("user_account", req.getAccount());
		
		httpSession.setMaxInactiveInterval(10);

		// END

		return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage(), verifyCode);
	}

	@PostMapping(value = "/api/register2")
	public RegisterRes register2(@RequestBody RegisterReq req) {
		RegisterRes res = new RegisterRes();
		Register reg = registerService.register(req.getAccount(), req.getPwd(), req.getName(), req.getAge(),
				req.getCity());
		res.setRegister(reg);
		res.setMessage("Register successfully.");
		return res;

	}

	@PostMapping(value = "/api/active_account")
	public RegisterRes activeAccount(@RequestBody RegisterReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
		return registerService.activeAccount(req.getAccount());
	}

	@PostMapping(value = "/api/login")
	public RegisterRes login(@RequestBody LoginInfo loginInfo, HttpSession httpSession) {
		if (!StringUtils.hasText(loginInfo.getAccount()) || !StringUtils.hasText(loginInfo.getPwd())) {
			return new RegisterRes("Parameter is error.");
		}

		Register result = registerService.findById(loginInfo.getAccount());
		if (result == null) {
			return new RegisterRes("UserInfo not found.");
		}

		httpSession.setAttribute("user_account", result.getAccount());
		httpSession.setMaxInactiveInterval(20);

		return new RegisterRes(result, "Login successfully.");
	}

	@PostMapping(value = "/api/logout")
	public RegisterRes logout(HttpSession httpSession) {
		httpSession.removeAttribute("user_account");
		return new RegisterRes("Logout successfully.");
	}

	@PostMapping(value = "/api/get_user_info")
	public RegisterRes getUserInfo(HttpSession httpSession) {
		Object attValue = httpSession.getAttribute("user_account");

		if (attValue != null) {
			String account = attValue.toString();
			Register result = registerService.findById(account);
			return new RegisterRes(result, "Get user info successfully.");
		}

		return new RegisterRes("User info is empty.");
	}

	private RegisterRes checkParam(RegisterReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		} else if (!StringUtils.hasText(req.getPwd())) {
			return new RegisterRes(RegisterRtnCode.PWD_REQUIRED.getMessage());
		} else if ((!StringUtils.hasText(req.getName()))) {
			return new RegisterRes(RegisterRtnCode.NAME_REQUIRED.getMessage());
		}
		return null;
	}

//	private RegisterRes checkParam2(RegisterReq req) {
//		if (!StringUtils.hasText(req.getAccount()) || !StringUtils.hasText(req.getPwd())
//				|| (!StringUtils.hasText(req.getName()))) {
//			return new RegisterRes("ERROR. Account, pwd, name cannot be null or empty.");
//		}
//		return null;
//	}

	public int produceRandomVerifyCode() {
		double random = Math.random() * 10000;
		int verifyCode = (int) Math.round(random);
		return verifyCode;
	}

}
