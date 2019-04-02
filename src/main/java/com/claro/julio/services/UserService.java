package com.claro.julio.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.claro.julio.security.UserSS;

//Restrição de conteúdo: cliente só recupera ele mesmo
public class UserService {
	
	public static UserSS authenticated() {
		try {
			//retorna o usuário que esta logado no sistema
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
