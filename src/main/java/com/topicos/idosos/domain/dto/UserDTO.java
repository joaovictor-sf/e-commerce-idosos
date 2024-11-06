package com.topicos.idosos.domain.dto;

import com.topicos.idosos.domain.User;

public record UserDTO(Long id, String email, String password, String name, String role) {

}
