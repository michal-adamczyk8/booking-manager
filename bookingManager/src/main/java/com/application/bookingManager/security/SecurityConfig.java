package com.application.bookingManager.security;


import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.application.bookingManager.entity.User;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${admin.password}")
	private String adminPassword;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/users").hasAnyRole("ADMIN", "EMPLOYEE")
			.antMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("ADMIN", "EMPLOYEE")
			.antMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/users/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/users").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/users/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/api/rooms").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/api/rooms/**").hasAnyRole("ADMIN", "EMPLOYEE")
			.antMatchers(HttpMethod.POST, "/api/rooms").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/rooms/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/rooms").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/rooms/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/rooms/**").hasRole("ADMIN")			
			.and()
			.httpBasic()
			.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("admin").password(adminPassword).roles("EMPLOYEE", "ADMIN"))
			.withUser(users.username("jsmith").password("qwerty").roles("EMPLOYEE"))
			.withUser(users.username("jdoe").password("mySecret").roles("EMPLOYEES"));
		
		}
}
