package com.avan.projetoT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avan.projetoT.domain.Reserva;
import com.avan.projetoT.service.impl.ReservaServiceImpl;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaServiceImpl reservaService;

    // Criar uma reserva
    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestParam int produtoId, @RequestParam long usuarioId) {
        Reserva reserva = reservaService.criarReserva(produtoId, usuarioId);

        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.badRequest().build();  // Produto ou usuário não encontrado
        }
    }

    // Cancelar uma reserva
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Reserva> cancelarReserva(@PathVariable int id) {
        Reserva reserva = reservaService.cancelarReserva(id);

        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();  // Reserva não encontrada
        }
    }

    // Consultar uma reserva
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> consultarReserva(@PathVariable int id) {
        Reserva reserva = reservaService.consultarReserva(id);

        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();  // Reserva não encontrada
        }
    }
}
