package com.flaminiovilla.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/v2/api-docs").permitAll() //Added to expose api-docs for aggregate on zuul-swagger
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic()
				.and()
				.csrf().disable();
	}
}
