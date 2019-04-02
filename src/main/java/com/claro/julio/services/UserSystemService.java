package com.claro.julio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.claro.julio.domain.UserSystem;
import com.claro.julio.domain.enums.Perfil;
import com.claro.julio.repositories.UserSystemRepository;
import com.claro.julio.security.UserSS;
import com.claro.julio.services.exceptions.AuthorizationException;
import com.claro.julio.services.exceptions.ObjectNotFoundException;

@Service
public class UserSystemService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UserSystemRepository repo;

	public UserSystem findByEmail(String email) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		UserSystem u = repo.findByEmail(email);
		// capturada por resources - @ControllerAdvice 
		if (u == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! email: " + email + ", Tipo: " + UserSystem.class.getName());
		}
		return u;
	}
	
	//apenas ADMIN ou o próprio usuario pode buscar
	public UserSystem find(Integer id) {

		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<UserSystem> us = repo.findById(id);
		// capturada por resources - @ControllerAdvice -
		return us.orElseThrow(() -> new ObjectNotFoundException(
				"User não encontrado: " + id + ", Tipo: " + UserSystem.class.getName()));
		
	}
	
	public UserSystem insert(UserSystem us) {
		us.setId(null);
		us.setSenha(pe.encode(us.getSenha()));
		for(Perfil p : us.getPerfis()) {
			us.addPerfil(p);
		}
		us = repo.save(us);
		return us;
	}
	
	public UserSystem update(UserSystem updateUs) {
		UserSystem us = find(updateUs.getId());
		System.out.println(">>>>>>>>>> find :" + us.getNome());
		us.setNome(updateUs.getNome());
		us.setSenha(pe.encode(updateUs.getSenha()));
		return repo.save(us);
	}
	

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
		
	}
	
	public List<UserSystem> findAll() {
		return repo.findAll();
	}
	
	public UserSystem encode(UserSystem us) {
		String pw = pe.encode(us.getSenha());
		us.setSenha(pw);
		return us;
	}
	
}
