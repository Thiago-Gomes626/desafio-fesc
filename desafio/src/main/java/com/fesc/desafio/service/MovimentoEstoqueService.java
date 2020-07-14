package com.fesc.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.desafio.exception.ResourceNotFoundException;
import com.fesc.desafio.model.MovimentoEstoque;
import com.fesc.desafio.model.Produto;
import com.fesc.desafio.repository.MovimentoEstoqueRepository;

@Service
public class MovimentoEstoqueService {

	@Autowired
	private MovimentoEstoqueRepository movimentoEstoqueRepository;
	
	public List<MovimentoEstoque> getAllMovimentoEstoque() {
		return movimentoEstoqueRepository.findAll();
	}
	
	public List<MovimentoEstoque> getMovimentoEstoqueByProdCod(Long codProd) {
		Produto produto = new Produto();
		produto.setCodigo(codProd);
		return movimentoEstoqueRepository.findMovimentoEstoqueByCodProd(produto);
	}
	
	public boolean createMovimentoEstoque(MovimentoEstoque movimentoEstoque) {
		try {
			movimentoEstoqueRepository.save(movimentoEstoque);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public MovimentoEstoque updateMovimentoEstoque(MovimentoEstoque newMovimentoEstoque) throws ResourceNotFoundException {
		MovimentoEstoque movimentoEstoque = movimentoEstoqueRepository.findById(newMovimentoEstoque.getCodigo())
					.orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar movimento estoque com id: " + newMovimentoEstoque.getCodigo()));
		movimentoEstoque.setDataVenda(newMovimentoEstoque.getDataVenda());
		movimentoEstoque.setProduto(newMovimentoEstoque.getProduto());
		movimentoEstoque.setQntMovimentada(newMovimentoEstoque.getQntMovimentada());
		movimentoEstoque.setTipo(newMovimentoEstoque.getTipo());
		movimentoEstoque.setValorVenda(newMovimentoEstoque.getValorVenda());
		movimentoEstoqueRepository.save(movimentoEstoque);
		return movimentoEstoque;
	}
	
	public boolean deleteMovimentoEstoque(Long cod) throws ResourceNotFoundException {
		MovimentoEstoque movimentoEstoque = movimentoEstoqueRepository.findById(cod)
				.orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar movimento estoque com id: " + cod));
		try {
			movimentoEstoqueRepository.delete(movimentoEstoque);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
