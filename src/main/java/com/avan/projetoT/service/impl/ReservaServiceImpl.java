package com.avan.projetoT.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avan.projetoT.domain.Produto;
import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.domain.User;
import com.avan.projetoT.repository.ProdutoRepository;
import com.avan.projetoT.repository.ReservaRepository;
import com.avan.projetoT.repository.UserRepository;
import com.avan.projetoT.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;  // Para acessar o Produto

    @Autowired
    private UserRepository usuarioRepository; 
    
    /*public void criarReserva(Reserva reserva) {
        reserva.setDataReserva(LocalDate.now());
        reserva.setStatus("Ativa"); // Setting default status to "Active"
        reservaRepository.save(reserva);
    }*/

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva consultarReserva(int id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva cancelarReserva(int id) {
        Reserva reserva = consultarReserva(id);
        if (reserva != null) {
            reserva.setStatus("Cancelada"); // Update the status instead of deleting
            reservaRepository.save(reserva);
        }
        
        return reserva;
        
    }
    
    @Override
	public Reserva criarReserva(int produtoId, long usuarioId) {
		Optional<Produto> produto = produtoRepository.findById(produtoId);
        Optional<User> usuario = usuarioRepository.findById(usuarioId);

        if (produto.isPresent() && usuario.isPresent()) {
            Reserva reserva = new Reserva();
            reserva.setProduto(produto.get());
            reserva.setUsuario(usuario.get());
            reserva.setDataReserva(LocalDate.now());
            reserva.setStatus("Pendente");  // O status pode ser "Pendente" ao ser criada
            return reservaRepository.save(reserva);
        }

        return null;  // Produto ou usuário não encontrados
	}

    /*
	@Override
	public Reserva criarReserva(int produtoId, long usuarioId) {
		Optional<Produto> produto = produtoRepository.findById(produtoId);
        Optional<User> usuario = usuarioRepository.findById(usuarioId);

        if (produto.isPresent() && usuario.isPresent()) {
            Reserva reserva = new Reserva();
            reserva.setProduto(produto.get());
            reserva.setUsuario(usuario.get());
            reserva.setDataReserva(LocalDate.now());
            reserva.setStatus("Pendente");  // O status pode ser "Pendente" ao ser criada
            return reservaRepository.save(reserva);
        }

        return null;  // Produto ou usuário não encontrados
	}

	@Override
	public Reserva cancelarReserva(int id) {
		Optional<Reserva> reserva = reservaRepository.findById(id);

        if (reserva.isPresent()) {
            Reserva reservaExistente = reserva.get();
            reservaExistente.setStatus("Cancelada");
            return reservaRepository.save(reservaExistente);
        }

        return null;  // Reserva não encontrada
	}

	@Override
	public Reserva consultarReserva(int id) {
		return reservaRepository.findById(id).orElse(null);  // Retorna null caso não encontre
	}

	@Override
	public List<Reserva> listarReservas() {
		// TODO Auto-generated method stub
		return null;
	}*/

}