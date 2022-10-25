package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Person;
import com.example.demo_project.vo.PersonReq;

public interface PersonService {
//	public Person getPersonInfo(String id, String name, int age, String city);
	
	//classroom_1020
	public List<Person> getPersonInfo();
	public Person getPersonInfoID(String id);
	public List<Person> getPersonInfoByAgeLargerThan(int age);
	
	public Person getPersonNameAge(String name, int age);
	public List<Person> getPersonNameAgeLargerThan(String name, int age);
	

}
