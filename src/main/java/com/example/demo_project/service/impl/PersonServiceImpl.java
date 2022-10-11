package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public Person getPersonInfo(String id, String name, int age, String city) {
		Person per = new Person();
		per.setId(id);
		per.setName(name);
		per.setAge(age);
		per.setCity(city);

		return per;
	}
	
	public void printPersonArrributes(Person person) {
		System.out.println("ID: "  + person.getId());
		System.out.println("NAME: "  + person.getName());
		System.out.println("AGE: "  + person.getAge());
		System.out.println("CITY: "  + person.getCity());

	}

}
