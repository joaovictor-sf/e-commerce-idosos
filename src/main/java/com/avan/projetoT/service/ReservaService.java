package com.avan.projetoT.service;

import java.util.List;

import com.avan.projetoT.domain.Reserva;

public interface ReservaService {

	public Reserva criarReserva(int produtoId, long usuarioId);
	 //public void criarReserva(Reserva reserva);

    // Cancelar a reserva
    public Reserva cancelarReserva(int id);

    // Consultar uma reserva pelo ID
    public Reserva consultarReserva(int id);
    
    public List<Reserva> listarReservas();
	
}
