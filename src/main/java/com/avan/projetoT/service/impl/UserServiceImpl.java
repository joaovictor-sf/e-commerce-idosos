package com.avan.projetoT.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avan.projetoT.domain.User;
import com.avan.projetoT.repository.UserRepository;
import com.avan.projetoT.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository usuarioRepository;

	@Override
	public User cadastrarUsuario(User usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Iterable<User> obterTodosUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public User autenticarUsuario(String email, String senha) {
		User usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario; // Login bem-sucedido
        }
        return null; // Login falhou
	}

}
