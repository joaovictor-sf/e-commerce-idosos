package com.avan.projetoT.domain.dto;

import java.time.LocalDate;

import com.avan.projetoT.domain.Produto;
import com.avan.projetoT.domain.ReservaStatus;
import com.avan.projetoT.domain.User;

public record ListedReserva(LocalDate dataReserva, ReservaStatus status, Long produtoId, Long usuarioId) {

}
