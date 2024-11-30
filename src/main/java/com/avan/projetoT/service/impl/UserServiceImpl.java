package com.avan.projetoT.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.domain.User;
import com.avan.projetoT.domain.dto.ListedEntrega;
import com.avan.projetoT.domain.dto.ListedReserva;
import com.avan.projetoT.domain.dto.ReservaRequest;
import com.avan.projetoT.repository.EntregaRepository;
import com.avan.projetoT.repository.ReservaRepository;
import com.avan.projetoT.repository.UserRepository;
import com.avan.projetoT.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository usuarioRepository;
	
	@Autowired
    private ReservaRepository reservaRepository;
	
	@Autowired
    private EntregaRepository entregaRepository;

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
	public Optional<User> atualizarUsuario(Long usuarioId, User usuarioUpdate) {
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

	@Override
	public List<ListedReserva> listarReservasPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(reserva -> new ListedReserva(
                        reserva.getDataReserva()
                        ,reserva.getStatus()
                        ,reserva.getProduto().getId()
                        ,reserva.getUsuario().getId()
                ))
                .collect(Collectors.toList());
    }

	@Override
	public List<ListedEntrega> listarEntregasPorUsuario(Long usuarioId) {
        return entregaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(entrega -> new ListedEntrega(
                        entrega.getId(),
                        entrega.getReserva().getId(),
                        entrega.getEnderecoEntrega(),
                        entrega.getStatusEntrega()
                ))
                .collect(Collectors.toList());
	}

}
