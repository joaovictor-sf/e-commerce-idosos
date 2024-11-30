package com.avan.projetoT.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.domain.StatusEntrega;
import com.avan.projetoT.repository.EntregaRepository;
import com.avan.projetoT.repository.ReservaRepository;
import com.avan.projetoT.service.EntregaService;

@Service
public class EntregaServiceImpl implements EntregaService{

	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public Optional<Entrega> criarEntrega(Long reservaId, String enderecoEntrega) {
		Optional<Reserva> reservaOpt = reservaRepository.findById(reservaId);

        if (reservaOpt.isPresent()) {
            Entrega entrega = new Entrega();
            entrega.setDataEntrega(new Date());
            entrega.setStatusEntrega(StatusEntrega.AGUARDANDO);
            entrega.setEnderecoEntrega(enderecoEntrega);
            entrega.setReserva(reservaOpt.get());
            entrega.setUsuario(reservaOpt.get().getUsuario());
            return Optional.of(entregaRepository.save(entrega));
        }

        return Optional.empty();
	}

	@Override
	public Optional<Entrega> atualizarStatusEntrega(Long entregaId, StatusEntrega novoStatus) {
		Optional<Entrega> entregaOpt = entregaRepository.findById(entregaId);

        if (entregaOpt.isPresent()) {
            Entrega entrega = entregaOpt.get();
            entrega.setStatusEntrega(novoStatus);
            return Optional.of(entregaRepository.save(entrega));
        }

        return Optional.empty();
	}

}
