package com.avan.projetoT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.Reserva;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
	List<Entrega> findByUsuarioId(Long id);
}
