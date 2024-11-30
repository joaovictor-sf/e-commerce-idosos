package com.avan.projetoT.domain.dto;

import com.avan.projetoT.domain.FormaPagamento;

public record PagamentoDTO(Long reservaId, Double valor, FormaPagamento formaPagamento) {

}
