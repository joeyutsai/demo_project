package com.example.demo_project.repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.Register;

public class RegisterDaoImpl extends BaseDao {

	public List<Register> doQueryByExpiredRegTime(Date date) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select R from Register R where R.regTime > :expiredDate");
//		sb.append(" select R from Register R").append(" where R.regTime > :expiredDate");
		Map<String, Object> params =  new HashMap<>();
		params.put("expiredDate", date);
		return doQuery(sb.toString(), params, Register.class);
	}

}
