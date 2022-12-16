package com.example.demo_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Users;
import com.example.demo_project.repository.UsersDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users item = usersDao.findByUserName(username);
		UserDetails userDetails = User.builder()
				.username(item.getUserName())
				.password(item.getPassword()) // 密碼前面加上"{noop}"使用NoOpPasswordEncoder，也就是不對密碼進行任何格式的編碼
				.roles(item.getRole())
				.build();

		return userDetails;
	}
}
