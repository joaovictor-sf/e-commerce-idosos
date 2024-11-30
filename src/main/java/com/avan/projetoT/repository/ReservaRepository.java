package com.avan.projetoT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avan.projetoT.domain.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	//List<Reserva> findAllByUsuario(Long id);
	List<Reserva> findByUsuarioId(Long id);
}
