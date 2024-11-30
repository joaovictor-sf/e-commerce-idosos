package com.avan.projetoT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.domain.User;
import com.avan.projetoT.domain.dto.ListedEntrega;
import com.avan.projetoT.domain.dto.ListedReserva;
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
            return ResponseEntity.status(401).body(null);
        }
    }
    
    @PutMapping("/{usuarioId}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable Long usuarioId, 
                                                  @RequestBody User usuarioUpdate) {
        Optional<User> usuarioAtualizado = usuarioService.atualizarUsuario(usuarioId, usuarioUpdate);

        if (usuarioAtualizado.isPresent()) {
            return ResponseEntity.ok(usuarioAtualizado.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
    
    @GetMapping("/{usuarioId}/reservas")
    public ResponseEntity<List<ListedReserva>> listarReservas(@PathVariable Long usuarioId) {
    	List<ListedReserva> reservas = usuarioService.listarReservasPorUsuario(usuarioId);
        return ResponseEntity.ok(reservas);
    }
    
    @GetMapping("/{usuarioId}/entregas")
    public ResponseEntity<List<ListedEntrega>> listarEntregas(@PathVariable Long usuarioId) {
    	 List<ListedEntrega> entregas = usuarioService.listarEntregasPorUsuario(usuarioId);
    	 return ResponseEntity.ok(entregas);
    }
}
