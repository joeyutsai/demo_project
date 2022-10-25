package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_project.entity.Person;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.PersonReq;

@Service
public class PersonServiceImpl implements PersonService {

	// * START Homework_1021 classromPractice_1024
	@Autowired
	private PersonDao personDao;
	
	@Override
	public List<Person> getPersonNameAgeLargerThan(String name, int age) {
		return personDao.findByNameAndAgeGreaterThan(name, age);		
	}
	
	@Override
	public Person getPersonNameAge(String name, int age) {
		return personDao.findByNameAndAge(name, age);		
	}
	
	@Override
	public List<Person> getPersonInfo() {
		return personDao.findAll();
	}

	@Override
	public Person getPersonInfoID(String id) {
		return personDao.findById(id).orElse(new Person());

//		Optional<Person> personOp = personDao.findById(id);

//		// method1
//		if (personOp.isPresent()) {
//			return personOp.get();
//		} else {
//			return new Person();
//		}

		// method2
//		return personOp.orElse(new Person());
	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {
		return personDao.findByAgeGreaterThan(age);

//		List<Person> listPerson = getPersonInfo();
//		List<Person> res = new ArrayList<>();
//
//		for (Person item : listPerson) {
//			if (age < item.getAge()) {
//				res.add(item);
//			}
//		}
//		return res;
	}

//	@Override
//	public Person getPersonInfo(String id, String name, int age, String city) {
//		Person per = new Person();
//		per.setId(id);
//		per.setName(name);
//		per.setAge(age);
//		per.setCity(city);
//
//		return per;
//	}

//	public void printPersonArrributes(Person person) {
//		System.out.println("ID: " + person.getId());
//		System.out.println("NAME: " + person.getName());
//		System.out.println("AGE: " + person.getAge());
//		System.out.println("CITY: " + person.getCity());
//
//	}

//	// * START Homework_1020

//	public Person tom = new Person("001", "Tom", 20);
//	public Person jack = new Person("002", "Jack", 25);
//	public Person sam = new Person("003", "Sam", 50);

//	@Override
//	public List<Person> getPersonInfo() {
//		List<Person> list = personDao.findAll();
//		return list;
//
////		Person tom = new Person("001", "Tom", 20);
////		Person jack = new Person("002", "Jack", 25);
////		Person sam = new Person("003", "Sam", 50);
////		List<Person> listPerson = new ArrayList<>();
////		listPerson.add(tom);
////		listPerson.add(jack);
////		listPerson.add(sam);
////		return listPerson;
//	}

//	@Override
//	public Person getPersonInfoID(String id) {
//		Person res = new Person();
//
//		// method1
//		for (Person item : getPersonInfo()) {
//			if (id.equalsIgnoreCase(item.getId())) {
//				res = item;
//			}
//		}
//
//		return res;
//
////		// method2
////		if (req.getId().equalsIgnoreCase(tom.getId())) {
////			return tom;
////		} else if (req.getId().equalsIgnoreCase(jack.getId())) {
////			return jack;
////		} else if (req.getId().equalsIgnoreCase(sam.getId())) {
////			return sam;
////		} else {
////			return new Person();
////		}
////		return null;
//	}
//
//	@Override
//	public List<Person> getPersonInfoByAgeLargerThan(int age) {
//		List<Person> listPerson = getPersonInfo();
//
//		List<Person> res = new ArrayList<>();
//
//		// method1
//		for (Person item : listPerson) {
//			if (age < item.getAge()) {
//				res.add(item);
//			}
//		}
//
//		return res;
//
////		// method2
////		for (int i = 0; i < listPerson.size(); i++) {
////			if (listPerson.get(i).getAge() > age) {
////				if (listPerson.get(i).getName().equalsIgnoreCase("tom")) {
////					res.add(tom);
////				} else if (listPerson.get(i).getName().equalsIgnoreCase("jack")) {
////					res.add(jack);
////				} else if (listPerson.get(i).getName().equalsIgnoreCase("sam")) {
////					res.add(sam);
////				}
////			}
////		}
////		return res;
//
//	}
//	// * END Homework_1020

}
