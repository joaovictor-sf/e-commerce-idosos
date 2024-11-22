package com.avan.projetoT.service;

import com.avan.projetoT.domain.Reserva;

public interface ReservaService {

	public Reserva criarReserva(int produtoId, long usuarioId);

    // Cancelar a reserva
    public Reserva cancelarReserva(int id);

    // Consultar uma reserva pelo ID
    public Reserva consultarReserva(int id);
	
}
