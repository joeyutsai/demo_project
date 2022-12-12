package com.example.demo_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

// 定義成元件，給Spring boot託管
@Component

// 定義成切面
@Aspect
public class ExecuteTimeLogAspect {

	// 切入點，定義 controller 或 service 下所有程式都會被包含
	// execution（）中一開始可加上權限 ex: public, private
	// execution（）中第一個星號為 返回型態 ex: void, String ...
	// com.example.demo_project.controller 為 package 位置
	// execution（）中第二個星號為 所有類別
	// execution（）中第三個星號為 所有方法
	// execution（）中第三個星號後面的(..)為 方法中的參數，兩個點表示所有參數
//	@Pointcut("execution (* com.example.demo_project.controller.*.*(..))")
//	@Pointcut("execution (public * com.example.demo_project.service.impl.*.*(..))")
	@Pointcut("execution (* com.example.demo_project.service.impl.*.*(..))")
	public void pointcut() {

	}

	@Before("pointcut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("===== before advice =====");
	}

	@After("pointcut()")
	public void after(JoinPoint joinPoint) {
		System.out.println("===== after advice =====");
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("== *** == around advice start == *** ==");

		MethodSignature signature = (MethodSignature) pjp.getSignature();
		// 取得方法名稱
		System.out.println("Get Function name --> pjp.getSignature(): " + signature.getName());

		long startTime = System.currentTimeMillis();
		// 呼叫 proceed() 才會開始執行原方法
		Object result = pjp.proceed();
		long spentTime = System.currentTimeMillis() - startTime;
		System.out.println("--> result: " + result);
		System.out.println("--> spentTime: " + spentTime);
		System.out.println("== *** == around advice end == *** ==");

		return result;
	}

	// 因為@AfterReturning()內只有一個參數，所以可省略 pointcut =
//	@AfterReturning(pointcut = "pointcut()")
	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("======= after returning =======");
	}

	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		// 取得方法名稱
		System.out.println("--> signature.getName(): " + signature.getName());
		// 取得錯誤訊息
		System.out.println("ERROR: --> throwable.getMessage(): " + throwable.getMessage());

		System.out.println("======== afterThrowing advice ========");
	}

//	// 指定方法名稱 ex: 指定findAll()的方法
//	@Pointcut("execution (* com.example.demo_project.service.impl.*.findAll(..))")
//	public void pointcut2() {
//	}
//	@Before("pointcut2()")
//	public void before2(JoinPoint joinPoint) {
//		System.out.println("===== before2 advice =====");
//	}
//	@After("pointcut2()")
//	public void after2(JoinPoint joinPoint) {
//		System.out.println("===== after2 advice =====");
//	}

}
