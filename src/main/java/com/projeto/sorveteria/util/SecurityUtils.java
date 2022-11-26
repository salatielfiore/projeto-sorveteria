package com.projeto.sorveteria.util;

import com.projeto.sorveteria.domain.funcionario.Funcionario;
import com.projeto.sorveteria.infrastructure.web.security.LoggerUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityUtils {

	public static LoggerUser loggedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}
		
		return (LoggerUser) authentication.getPrincipal();
	}
	
	public static Funcionario loggedCliente() {
		LoggerUser loggedUser = loggedUser();
		
		if(loggedUser == null) {
			throw new IllegalStateException("Não existe um usuário logado");
		}
		
		if(loggedUser.getFuncionario() == null) {
			throw new IllegalMonitorStateException("O usuário logado não e um Funcionario");
		}
		
		return  loggedUser.getFuncionario();
	}

	
}
