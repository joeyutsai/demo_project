package com.example.demo_project.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import com.example.demo_project.annotation.ConditionalOnB;
import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterRes;

//@ConditionalOnB
@EnableScheduling
@Service
public class RegisterImpl2 implements RegisterService {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {

		// 不能註冊已存在帳號
		if (registerDao.existsById(account)) {
			return null;
		}

		Register reg = new Register(account, pwd, name, age, city);
		reg.setRegTime(new Date());
		reg.setRole("General");
		return registerDao.save(reg);

	}

//	public Register register2(String account, String pwd, String name, int age, String city) {
//		//practice
//		Register newRegister = new Register(account, pwd, name, age, city);
//		registerDao.save(newRegister);
//		return newRegister;
//		return null;
//	}

	@Override
	public RegisterRes activeAccount(String account) {
		Optional<Register> regOp = registerDao.findById(account);

		if (regOp.isPresent()) {
			Register reg = regOp.get();
			reg.setActive(true);
			registerDao.save(reg);
			return new RegisterRes(null, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.FAIL.getMessage());
	}

	@Override
	public RegisterRes addRole(String account, List<String> roleList) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>();

			// remove duplicated roleList (because Set<> not allow duplicated item)
			for (String str : roleList) {
				roleSet.add(str);
			}

			// remove the same role(roleList) which is already in DB
			Register reg = regOp.get();
			String role = reg.getRole(); // use comma to separate different role. For example: General, SA, PM
			String[] roleArray = role.split(","); // separate roles by comma, so we can get: roleArray{General, SA, PM}
			for (int i = 0; i < roleArray.length; i++) { // remove front and end space: trim()
				String item = roleArray[i].trim();
				roleSet.add(item);
			}
//			for (String item : roleArray) { // remove space: trim()
//			item.trim();
//			roleSet.add(item);
//			}
			reg.setRole(roleSet.toString());
			String newString = roleSet.toString().substring(1, roleSet.size() - 1);
			reg.setRole(newString);
//			// START test
//			reg.setRole(roleSet.toString().replace("[", "").replace("]", ""));
//			System.out.println(reg.getRole());
//			// END test

			registerDao.save(reg);
			return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRoleSet(String account, Set<String> roleList) {
		Optional<Register> regOp = registerDao.findById(account);
		if (regOp.isPresent()) {
			Set<String> roleSet = new HashSet<>();

			// remove duplicated roleList (because Set<> not allow duplicated item)
			for (String str : roleList) {
				roleSet.add(str);
			}

			// remove the same role(roleList) which is already in DB
			Register reg = regOp.get();
			String role = reg.getRole(); // use comma to separate different role. For example: General, SA, PM
			String[] roleArray = role.split(","); // separate roles by comma, so we can get: roleArray{General, SA, PM}
			for (int i = 0; i < roleArray.length; i++) { // remove front and end space: trim()
				String item = roleArray[i].trim();
				roleSet.add(item);
			}
			
			// remove "[" & "]"
			reg.setRole(roleSet.toString());
			String newString = roleSet.toString().substring(1, roleSet.size() - 1);
			reg.setRole(newString);

			registerDao.save(reg);
			return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null, RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	
	}

	@Scheduled(fixedRateString = "${heartbeat.ms}")
	public void schedulePrintDate() {
//		System.out.println("--> RegisterImpl2");
//		System.out.println(new Date());
	}

	@Override
	public Register findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
