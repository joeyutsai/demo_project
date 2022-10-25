package com.example.demo_project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Company;
import com.example.demo_project.entity.OrgCompanyId;
import com.example.demo_project.repository.CompanyDao;
import com.example.demo_project.service.ifs.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public List<Company> findAll() {
		return companyDao.findAll();
	}

	@Override
	public Company findById(String orgId, String companyId) {
		return companyDao.findById(new OrgCompanyId(orgId, companyId)).orElse(new Company());
//		// method1
//		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
//		return companyDao.findById(orgCompanyId).orElse(new Company());

//		// method2
//		Optional<Company> companyOp = companyDao.findById(orgCompanyId);
//		return companyOp.orElse(new Company());
	}

	@Override
	public Company updateById(String orgId, String companyId) {
		OrgCompanyId orgCompanyId = new OrgCompanyId(orgId, companyId);
		Optional<Company> companyOp = companyDao.findById(orgCompanyId);
		// update name
		if (companyOp.isPresent()) {
			Company com = companyOp.get();
			com.setCompanyName("A02");
			Company newcom = companyDao.save(com);
			return newcom;
		}
		return new Company();
	}

	@Override
	public Company saveCompany(String orgId, String companyId, String companyName) {
		Company com = new Company(orgId, companyId, companyName);
		return companyDao.save(com);
	}

}
