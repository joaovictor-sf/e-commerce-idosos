package com.avan.projetoT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avan.projetoT.domain.User;
import com.avan.projetoT.domain.dto.LoginDTO;
import com.avan.projetoT.service.UserService;
import com.avan.projetoT.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
	
	@Autowired
    private UserServiceImpl usuarioService;

	@PostMapping("/cadastro")
    public ResponseEntity<User> cadastrarUsuario(@RequestBody User usuario) {
        User usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuarioCadastrado);
    }

    // Endpoint para obter todos os usuários cadastrados
    @GetMapping
    public ResponseEntity<Iterable<User>> obterUsuarios() {
        Iterable<User> usuarios = usuarioService.obterTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO) {
    	User usuarioAutenticado = usuarioService.autenticarUsuario(loginDTO.getEmail(), loginDTO.getSenha());
        if (usuarioAutenticado != null) {
            return ResponseEntity.ok(usuarioAutenticado);
        } else {
            return ResponseEntity.status(401).body(null); // 401 Unauthorized
        }
    }
}
