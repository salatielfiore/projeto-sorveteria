package com.projeto.sorveteria.infrastructure.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new AuthenticationSuccessHandlerImpl();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/images/**","/css/**").permitAll()
			.antMatchers("/home").hasAnyRole(Role.ADMIN.toString(), Role.USUARIO.toString())
			.antMatchers("/restaurante/**").hasRole(Role.ADMIN.toString())
			.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.failureUrl("/login-error")
					.successHandler(authenticationSuccessHandler())
					.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.permitAll();
			
	}

}
