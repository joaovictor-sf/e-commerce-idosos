package com.avan.projetoT.service;

import java.util.List;
import java.util.Optional;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.domain.User;
import com.avan.projetoT.domain.dto.ListedEntrega;
import com.avan.projetoT.domain.dto.ListedReserva;

public interface UserService {
	public User cadastrarUsuario(User usuario);
	
	public Iterable<User> obterTodosUsuarios();
	
	public User autenticarUsuario(String email, String senha);
	
	 public Optional<User> atualizarUsuario(Long usuarioId, User usuarioUpdate);
	 
	 //public List<Reserva> listarReservasPorCliente(Long clienteId);
	 
	 public List<ListedReserva> listarReservasPorUsuario(Long usuarioId);
	 
	 public List<ListedEntrega> listarEntregasPorUsuario(Long usuarioId);
}
