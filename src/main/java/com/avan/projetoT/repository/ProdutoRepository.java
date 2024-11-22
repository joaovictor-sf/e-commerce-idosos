package com.avan.projetoT.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avan.projetoT.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
