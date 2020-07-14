package com.fesc.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fesc.desafio.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
