package com.claro.julio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.claro.julio.domain.UserSystem;

@Repository
public interface UserSystemRepository  extends JpaRepository<UserSystem, Integer>{

	@Transactional(readOnly=true)
	UserSystem findByEmail(String email);
	
}
