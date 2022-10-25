package com.example.demo_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.PersonReq;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping(value = "/api/getPersonInfo")
	public List<Person> getPersonInfo() {
		return personService.getPersonInfo();
	}
	
	@PostMapping(value = "/api/getPersonInfoID")
	public Person getPersonInfoID(@RequestBody PersonReq req){
		return personService.getPersonInfoID(req.getId());
	}
	
	@PostMapping(value = "/api/getPersonInfoByAgeLargerThan")
	public List<Person> getPersonInfoByAgeLargerThan(@RequestBody PersonReq req){
		return personService.getPersonInfoByAgeLargerThan(req.getAge());
	}
	
	@PostMapping(value = "/api/getPersonNameAge")
	public Person getPersonNameAge(@RequestBody PersonReq req) {
		return personService.getPersonNameAge(req.getName(), req.getAge());
	}
	
	@PostMapping(value = "/api/getPersonNameAgeLargerThan")
	public List<Person> getPersonNameAgeLargerThan(@RequestBody PersonReq req) {
		return personService.getPersonNameAgeLargerThan(req.getName(), req.getAge());
	}
}
