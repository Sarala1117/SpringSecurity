package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/* Spring Security JDBC Authentication*/


@EnableWebSecurity
public class SecurityJdbcConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	DataSource dataSource;
	
	/* Authentication */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.withDefaultSchema()
		.withUser(
				User.withUsername("maker")
				.password("12345")
				.roles("USER")
				)
		.withUser(
				User.withUsername("checker")
				.password("123456")
				.roles("ADMIN")			
				);
	}
	
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	/* Authorization */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/checker").hasRole("ADMIN")
		.antMatchers("/maker").hasAnyRole("USER","ADMIN")
		.antMatchers("/")
		.permitAll()
		.and().formLogin();
	}	

}
