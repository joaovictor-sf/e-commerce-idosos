package com.avan.projetoT.service;

import com.avan.projetoT.domain.Produto;

public interface ProdutoService {
	
	public Produto cadastrarProduto(Produto produto);

    public Iterable<Produto> obterTodosProdutos();


    public Boolean verificarDisponibilidade(Long id);

    public Produto atualizarEstoque(Long id, Boolean disponibilidade);

}
