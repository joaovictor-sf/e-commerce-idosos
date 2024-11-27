package com.avan.projetoT.service;

import java.util.Optional;

import com.avan.projetoT.domain.User;

public interface UserService {
	public User cadastrarUsuario(User usuario);
	
	public Iterable<User> obterTodosUsuarios();
	
	public User autenticarUsuario(String email, String senha);
	
	 public Optional<User> atualizarUsuario(long usuarioId, User usuarioUpdate);
}
