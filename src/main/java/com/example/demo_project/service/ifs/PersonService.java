package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Person;

public interface PersonService {
	public Person getPersonInfo(String id, String name, int age, String city);
	
//	default String getPersonId(String id) {
//		return id;
//	};
//	

}
