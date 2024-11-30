package com.avan.projetoT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avan.projetoT.domain.Produto;
import com.avan.projetoT.service.impl.ProdutoServiceImpl;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping("/cadastro")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        Produto produtoCadastrado = produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok(produtoCadastrado);
    }

    @GetMapping
    public ResponseEntity<Iterable<Produto>> obterProdutos() {
        Iterable<Produto> produtos = produtoService.obterTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}/disponibilidade")
    public ResponseEntity<Boolean> verificarDisponibilidade(@PathVariable Long id) {
        Boolean disponibilidade = produtoService.verificarDisponibilidade(id);
        return ResponseEntity.ok(disponibilidade);
    }

    @PutMapping("/{id}/estoque")
    public ResponseEntity<Produto> atualizarEstoque(@PathVariable Long id, @RequestBody Boolean disponibilidade) {
        Produto produtoAtualizado = produtoService.atualizarEstoque(id, disponibilidade);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
