package com.gilvam.helpdesk.security.jwt;

import com.gilvam.helpdesk.enums.ProfileEnum;
import com.gilvam.helpdesk.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * converte perfil do usuario para o formato utilizado pelo spring security
	 * @param profileEnum
	 * @return
	 */
	private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}

	/**
	 * converte user para JwtUser
	 * @param user
	 * @return
	 */
	public static JwtUser create (User user) {//Gera um JWT user com os dados do usuario
		return new JwtUser(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				mapToGrantedAuthorities(user.getProfile())
		);
	}
}
