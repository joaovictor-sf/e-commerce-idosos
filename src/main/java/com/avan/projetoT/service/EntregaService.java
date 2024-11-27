package com.avan.projetoT.service;

import java.util.Optional;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.StatusEntrega;

public interface EntregaService {
	public Optional<Entrega> criarEntrega(int reservaId, String enderecoEntrega);

    public Optional<Entrega> atualizarStatusEntrega(int entregaId, StatusEntrega novoStatus);
}
