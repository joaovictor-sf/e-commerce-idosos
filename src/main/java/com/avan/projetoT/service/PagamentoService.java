package com.avan.projetoT.service;

import java.util.Optional;

import com.avan.projetoT.domain.FormaPagamento;
import com.avan.projetoT.domain.Pagamento;

public interface PagamentoService {
	
    public Optional<Pagamento> criarPagamento(int reservaId, Double valor, FormaPagamento formaPagamento);
}
