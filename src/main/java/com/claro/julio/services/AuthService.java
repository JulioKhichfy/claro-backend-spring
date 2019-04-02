package com.claro.julio.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.claro.julio.domain.UserSystem;
import com.claro.julio.repositories.UserSystemRepository;
import com.claro.julio.services.exceptions.ObjectNotFoundException;


@Service
public class AuthService {

	@Autowired
	private UserSystemRepository userSystemRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	private Random rand = new Random();
	
	public String sendNewPassword(String email) {
		
		UserSystem userSystem = userSystemRepository.findByEmail(email);
		if (userSystem == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		userSystem.setSenha(pe.encode(newPass));
		
		userSystemRepository.save(userSystem);
		return newPass;
		
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
