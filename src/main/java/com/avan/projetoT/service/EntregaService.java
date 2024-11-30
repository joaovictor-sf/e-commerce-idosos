package com.avan.projetoT.service;

import java.util.Optional;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.StatusEntrega;

public interface EntregaService {
	public Optional<Entrega> criarEntrega(Long reservaId, String enderecoEntrega);

    public Optional<Entrega> atualizarStatusEntrega(Long entregaId, StatusEntrega novoStatus);
}
