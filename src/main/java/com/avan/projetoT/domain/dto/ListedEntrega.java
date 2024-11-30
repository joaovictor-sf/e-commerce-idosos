package com.avan.projetoT.domain.dto;

import com.avan.projetoT.domain.StatusEntrega;

public record ListedEntrega(Long entregaId, Long reservaId, String enderecoEntrega, StatusEntrega statusEntrega) {

}
