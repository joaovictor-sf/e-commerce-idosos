package com.avan.projetoT.service;

import java.util.List;

import com.avan.projetoT.domain.Reserva;

public interface ReservaService {

	public Reserva criarReserva(Long produtoId, Long usuarioId);
	 //public void criarReserva(Reserva reserva);

    public Reserva cancelarReserva(Long id);

    public Reserva consultarReserva(Long id);
    
    public List<Reserva> listarReservas();
	
}
