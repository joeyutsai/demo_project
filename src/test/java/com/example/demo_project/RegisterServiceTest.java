package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;

@SpringBootTest(classes = DemoProjectApplication.class)
public class RegisterServiceTest {
	@Autowired
	private RegisterService registerService;

	@Autowired
	private RegisterDao registerDao;
	
	
	@Test
	public void addRoleListTest() {
		
	}
	
	
	@Test
	public void addRoleTest() {
		Register reg = registerService.register("A99", "TestPwd", "TestName", 99, "TestCity");
		List<String> roleList = new ArrayList<>();
		roleList.add("SA");
		roleList.add("SD");
		roleList.add("SA");
		roleList.add("SD");

		registerService.addRole("A99", roleList);
		

		Register checkReg = registerDao.findById("A99").get();
		System.out.println(checkReg.getAccount() + " Role: " + checkReg.getRole());
		registerDao.delete(checkReg);
		
	}
	
	@Test
	public void addRoleTestPractice() {
		Register reg = registerService.register("A99", "TestPwd", "TestName", 99, "TestCity");
		reg.setRole("TestRole");
		registerDao.save(reg);
		
		Register newReg = registerDao.findById("A99").get();

		System.out.println(newReg.getAccount() + ": " + newReg.getRole());
		
		registerDao.delete(newReg);
		
	}

	@Test
	public void activeAccountTest() {
		Register reg = registerService.register("A99", "TestPwd", "TestName", 99, "TestCity");
		Assert.isTrue(!reg.isActive(), "Account is active.");

		registerService.activeAccount("A99");
		Register newReg = registerDao.findById("A99").get();
		Assert.isTrue(newReg.isActive(), "Account is inactive.");

		System.out.println(newReg.getAccount() + ": " + newReg.isActive());
		
		registerDao.delete(newReg);
		
	}

	@Test
	public void registerTest() {
		Register reg = registerService.register("A01", "Ptom123", "Tom", 30, "Taipei");
//		Assert.notNull(reg, "Result is null!");
//		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A01"), "Account error!");
//		
//		registerDao.delete(reg);
//		Optional<Register> reg2 = registerDao.findById("A01");
//		Assert.notNull(reg, "Result is null!");
//		Assert.isTrue(!registerDao.findById("A01").isPresent(), "Reg is not null!");
//		Assert.isTrue(!registerDao.existsById("A01"), "Reg is not null!");

	}

//	@Test
//	public void registerTest2() {
//		// practice
//		Register reg = registerService.register("A01", "P1234", "Tom", 30, "Taipei");		
//		Register res = registerDao.findById(reg.getAccount()).orElse(new Register());
//		System.out.println("ACCOUNT: " + res.getAccount() + " NAME: " + res.getName() + " AGE: " + res.getAge()
//				+ " CITY: " + res.getCity());
//
//	}

	
	// START 11/28 Mon
	@Test
	public void updateRegisterInfoDaoTest() {
		int result = registerDao.updateRegisterInfo("newPaul", 30, "Keelung", new Date(), "A04");
		System.out.println("------> Result: " + result);
	}
	// END 11/28 Mon

	// START 11/29 Tue
	@Test
	public void doQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date);
		System.out.println("--> Result size: " + result.size());
	}
	// END 11/29 Tue


}
