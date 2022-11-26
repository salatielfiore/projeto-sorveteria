package com.projeto.sorveteria.infrastructure.web.security;

import java.util.Collection;

import com.projeto.sorveteria.domain.funcionario.Funcionario;
import com.projeto.sorveteria.util.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class LoggerUser implements UserDetails {

	private Funcionario funcionario;
	private Role role;
	private Collection<? extends GrantedAuthority> roles;

	public LoggerUser(Funcionario funcionario) {
		this.funcionario = funcionario;

		Role role;

		role = funcionario.isAdm() ? Role.ADMIN : Role.USUARIO;

		this.role = role;
		this.roles = CollectionUtils.listOf(new SimpleGrantedAuthority("ROLE_" + role));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return funcionario.getPassword();
	}

	@Override
	public String getUsername() {
		return funcionario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Role getRole() {
		return role;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

}
