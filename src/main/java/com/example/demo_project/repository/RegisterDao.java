package com.example.demo_project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_project.entity.Register;

@Repository
public interface RegisterDao extends JpaRepository<Register, String>{
	
	@Transactional
	@Modifying
	@Query("update Register set name = :newName, age = :newAge, city = :newCity, regTime = :newRegTime " + "where account = :account ")
	public int updateRegisterInfo(
			@Param("newName") String newName,
			@Param("newAge") int newAge,
			@Param("newCity") String newCity,
			@Param("newRegTime") Date newDate,
			@Param("account") String account
			);
	
	public List<Register> doQueryByExpiredRegTime(Date date);
	
}
