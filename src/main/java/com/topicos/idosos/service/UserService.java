package com.topicos.idosos.service;

import java.util.List;

import com.topicos.idosos.domain.dto.UserDTO;

public interface UserService {
    List<UserDTO> listAllUsers();
}
