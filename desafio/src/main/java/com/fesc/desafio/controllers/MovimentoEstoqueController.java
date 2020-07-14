package com.fesc.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fesc.desafio.exception.ResourceNotFoundException;
import com.fesc.desafio.model.MovimentoEstoque;
import com.fesc.desafio.service.MovimentoEstoqueService;

@RestController
@RequestMapping("/api/v1")
public class MovimentoEstoqueController {

	@Autowired
	private MovimentoEstoqueService movimentoEstoqueService;
	
	@GetMapping("/movimentoestoque")
	public List<MovimentoEstoque> getAllMovimentoEstoque() {
		return movimentoEstoqueService.getAllMovimentoEstoque();
	}
	
	@GetMapping("/movimentoestoquebyprodcod/{prodcod}")
	public List<MovimentoEstoque> getMovimentoEstoqueByProdCod(@PathVariable(value = "prodcod") Long prodCod) {
		return movimentoEstoqueService.getMovimentoEstoqueByProdCod(prodCod);
	}
	
	@PostMapping("/movimentoestoque")
	public boolean createMovimentoEstoque(@RequestBody MovimentoEstoque movimentoEstoque) {
		return movimentoEstoqueService.createMovimentoEstoque(movimentoEstoque);
	}
	
	@PutMapping("/movimentoestoque")
	public MovimentoEstoque updateMovimentoEstoque(@RequestBody MovimentoEstoque movimentoEstoque) throws ResourceNotFoundException {
		return movimentoEstoqueService.updateMovimentoEstoque(movimentoEstoque);
	}
	
	@DeleteMapping("movimentoestoque/{id}")
	public boolean deleteMovimentoEstoque(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return movimentoEstoqueService.deleteMovimentoEstoque(id);
	}
	
}
