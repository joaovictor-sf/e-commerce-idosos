package com.idosos.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.idosos.demo.domain.User;
import com.idosos.demo.domain.dto.UserDTO;
import com.idosos.demo.mapper.UserMapper;
import com.idosos.demo.repository.UserRepository;
import com.idosos.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		 User user = UserMapper.INSTANCE.toEntity(userDTO);
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        user = userRepository.save(user);
	        return UserMapper.INSTANCE.toDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return UserMapper.INSTANCE.toDTO(user);
	}

}
