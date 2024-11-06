package com.topicos.idosos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicos.idosos.domain.dto.UserDTO;
import com.topicos.idosos.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> listAllUsers() {
        userRepository.findAll();
        throw new UnsupportedOperationException("Unimplemented method 'listAllUsers'");
    }

}
