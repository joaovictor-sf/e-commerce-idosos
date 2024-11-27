package com.avan.projetoT.service.impl;

import java.util.Optional;

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

	@Override
	public Optional<User> atualizarUsuario(long usuarioId, User usuarioUpdate) {
		Optional<User> usuarioOpt = usuarioRepository.findById(usuarioId);

        if (usuarioOpt.isPresent()) {
            User usuario = usuarioOpt.get();
            usuario.setNome(usuarioUpdate.getNome());
            usuario.setEmail(usuarioUpdate.getEmail());
            usuario.setEndereco(usuarioUpdate.getEndereco());
            usuario.setSenha(usuarioUpdate.getSenha());
            usuario.setTelefone(usuarioUpdate.getTelefone());
            return Optional.of(usuarioRepository.save(usuario));
        }
        
		return Optional.empty();
	}

}
