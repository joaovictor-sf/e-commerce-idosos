package com.topicos.idosos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.topicos.idosos.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
