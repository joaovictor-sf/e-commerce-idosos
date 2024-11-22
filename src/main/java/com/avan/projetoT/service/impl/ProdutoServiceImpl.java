package com.avan.projetoT.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avan.projetoT.domain.Produto;
import com.avan.projetoT.repository.ProdutoRepository;
import com.avan.projetoT.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto cadastrarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public Iterable<Produto> obterTodosProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Boolean verificarDisponibilidade(int id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            return produto.verificarDisponibilidade();
        }
        return false;
	}

	@Override
	public Produto atualizarEstoque(int id, Boolean disponibilidade) {
		Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null) {
            produto.atualizarEstoque(disponibilidade);
            return produtoRepository.save(produto);
        }
        return null;
	}

}
