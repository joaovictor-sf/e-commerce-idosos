package com.avan.projetoT.service;

import com.avan.projetoT.domain.Produto;

public interface ProdutoService {
	
	public Produto cadastrarProduto(Produto produto);

    // Método para buscar todos os produtos
    public Iterable<Produto> obterTodosProdutos();

    // Método para verificar a disponibilidade de um produto
    public Boolean verificarDisponibilidade(Long id);

    // Método para atualizar a disponibilidade do produto
    public Produto atualizarEstoque(Long id, Boolean disponibilidade);

}
