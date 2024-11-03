package com.topicos.idosos.domain.dto;

import com.topicos.idosos.domain.UserRole;

public record RegisterDTO(String email, String password, String name, UserRole role) {

}
