package com.avan.projetoT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avan.projetoT.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	//User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);

}
