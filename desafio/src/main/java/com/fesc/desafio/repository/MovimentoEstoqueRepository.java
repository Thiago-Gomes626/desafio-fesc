package com.fesc.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fesc.desafio.model.MovimentoEstoque;
import com.fesc.desafio.model.Produto;

@Repository
public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Long> {

	@Query("select m from MovimentoEstoque m where m.produto.codigo = :#{#produto.codigo}")
	List<MovimentoEstoque> findMovimentoEstoqueByCodProd(@Param("produto") Produto produto);
	
}
