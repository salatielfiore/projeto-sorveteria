package com.projeto.sorveteria.infrastructure.web.security;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projeto.sorveteria.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		
		Role role = Objects.requireNonNull(SecurityUtils.loggedUser()).getRole();

		if(role == Role.ADMIN || role == Role.USUARIO) {
			response.sendRedirect("/home");
			
		}else {
			throw new IllegalStateException("Erro na autenticação");
		}

	}

}
