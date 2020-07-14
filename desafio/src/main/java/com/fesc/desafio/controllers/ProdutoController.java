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
import com.fesc.desafio.model.Produto;
import com.fesc.desafio.service.ProdutoService;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/produtos")
	public List<Produto> getAllProduto() {
		return produtoService.getAllProdutos();
	}
	
	@PostMapping("/produto")
	public boolean createProduto(@RequestBody Produto produto) {
		return produtoService.createProduto(produto);
	}
	
	@PutMapping("/produto")
	public Produto updateProduto(@RequestBody Produto produto) throws ResourceNotFoundException {
		return produtoService.updateProduto(produto);
	}
	
	@DeleteMapping("/produto/{id}")
	public boolean deleteProduto(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		return produtoService.deleteProduto(id);
	}
	
}
