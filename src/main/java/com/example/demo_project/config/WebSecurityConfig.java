package com.example.demo_project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo_project.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests() // 定義哪些URL需要被保護
		.antMatchers("/resources/**").permitAll() // resources 資料夾靜態資料可匿名存取
//		.antMatchers("/hello").hasRole("user") // 定義匹配到"/hello"底下的需要有USER的這個角色才能進去
//		.antMatchers("/hello2").hasRole("admin") // 定義匹配到"/hello2"底下的需要有ADMIN的這個角色才能進去
		.anyRequest().authenticated() // 其他尚未匹配到的URL都需要身份驗證
		.and().formLogin() // 自訂使用者login頁面
		.and().httpBasic() // 配置為HTTP基本認證
		;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//	// in memory
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// 將帳號密碼配置在記憶體當中
//		// 下面配置表示在記憶體中配置了兩個不同角色的使用者
//		// roles() 角色一定要配置，不然編譯時會出錯
//		auth.inMemoryAuthentication()
//				.withUser("Alice").roles("admin").password(passwordEncoder().encode("123"))
//				.and()
//				.withUser("Bob").roles("user").password(passwordEncoder().encode("123"));
//	}
//	
//	// 配置密碼加密元件
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	// 忽略特定網址，不進行帳密登入
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/hello.html").permitAll();
//	}
//	// 上面方法 configure(HttpSecurity http) 與此方法 configure(WebSecurity web)，兩個選其中一個用
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/hello.html");
//	}
}
