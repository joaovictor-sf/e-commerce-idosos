package com.avan.projetoT.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avan.projetoT.domain.Entrega;
import com.avan.projetoT.domain.StatusEntrega;
import com.avan.projetoT.service.EntregaService;
import com.avan.projetoT.service.impl.EntregaServiceImpl;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

	@Autowired
    private EntregaServiceImpl entregaService;

    @PostMapping
    public ResponseEntity<Entrega> criarEntrega(@RequestParam int reservaId,
                                                @RequestParam String enderecoEntrega) {
        Optional<Entrega> entrega = entregaService.criarEntrega(reservaId, enderecoEntrega);

        if (entrega.isPresent()) {
            return ResponseEntity.status(201).body(entrega.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{entregaId}/status")
    public ResponseEntity<Entrega> atualizarStatusEntrega(@PathVariable int entregaId,
                                                          @RequestParam StatusEntrega novoStatus) {
        Optional<Entrega> entregaAtualizada = entregaService.atualizarStatusEntrega(entregaId, novoStatus);

        if (entregaAtualizada.isPresent()) {
            return ResponseEntity.ok(entregaAtualizada.get());
        } else {
            return ResponseEntity.status(404).body(null);
        }

    }
}
