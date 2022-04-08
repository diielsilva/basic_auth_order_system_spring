package com.olix.stock_system.common.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.olix.stock_system.api.helper.PasswordHelper;
import com.olix.stock_system.domain.service.AuthService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private AuthService authService;
	private PasswordHelper passwordHelper;

	public SecurityConfig(AuthService authService, PasswordHelper passwordHelper) {
		this.authService = authService;
		this.passwordHelper = passwordHelper;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.authService).passwordEncoder(this.passwordHelper.getEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/users/**").hasAuthority("ADMIN").anyRequest().authenticated().and()
				.httpBasic().and().csrf().disable();
	}
}
