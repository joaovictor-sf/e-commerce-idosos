package com.idosos.demo.service;

import java.util.List;

import com.idosos.demo.domain.dto.UserDTO;

public interface UserService {
	
	 public UserDTO createUser(UserDTO userDTO);
	 
	 public List<UserDTO> getAllUsers();
	 
	 public UserDTO getUserById(Long id);

}
