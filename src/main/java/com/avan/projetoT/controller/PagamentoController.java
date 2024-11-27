package com.avan.projetoT.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avan.projetoT.domain.FormaPagamento;
import com.avan.projetoT.domain.Pagamento;
import com.avan.projetoT.domain.dto.PagamentoDTO;
import com.avan.projetoT.service.impl.PagamentoServiceImpl;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

	@Autowired
    private PagamentoServiceImpl pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> criarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        Optional<Pagamento> pagamento = pagamentoService.criarPagamento(pagamentoDTO.reservaId(), pagamentoDTO.valor(), pagamentoDTO.formaPagamento());

        if (pagamento.isPresent()) {
            return ResponseEntity.status(201).body(pagamento.get()); // 201 Created
        } else {
            return ResponseEntity.status(404).body(null); // 404 Not Found
        }
    }

}
