package com.topicos.idosos.domain.dto;

import com.topicos.idosos.domain.UserRole;

public record LoginResponseDTO(String token, UserRole role) {

}
