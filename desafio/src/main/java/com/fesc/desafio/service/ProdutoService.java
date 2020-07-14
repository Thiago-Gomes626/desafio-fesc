package com.fesc.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fesc.desafio.exception.ResourceNotFoundException;
import com.fesc.desafio.model.Produto;
import com.fesc.desafio.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto getProdById(Long id) throws ResourceNotFoundException {
		return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar um produto com o id: " + id));
	}
	
	public boolean createProduto(Produto produto) {
		try {
			produtoRepository.save(produto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Produto updateProduto(Produto newProduto) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(newProduto.getCodigo()).orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar um produto com o id: " + newProduto.getCodigo()));
		produto.setDescricao(newProduto.getDescricao());
		produto.setEstoque(newProduto.getEstoque());
		produto.setTipo(produto.getTipo());
		produto.setValorForn(newProduto.getValorForn());
		produtoRepository.save(produto);
		return produto;
	}
	
	public boolean deleteProduto(Long codProd) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(codProd).orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar um produto com o id: " + codProd));
		try {
			produtoRepository.delete(produto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean String(Long codProd, int qntToAdd) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(codProd).orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar um produto com o id: " + codProd));
		try {
			produto.setEstoque(produto.getEstoque() + qntToAdd);
			produtoRepository.save(produto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String removeEstoque(Long codProd, int qntToRemove) throws ResourceNotFoundException {
		Produto produto = produtoRepository.findById(codProd).orElseThrow(() -> new ResourceNotFoundException("Nao foi possivel encontrar um produto com o id: " + codProd));
		int newEstoque = produto.getEstoque() - qntToRemove;
		if (newEstoque > 0) {
			produto.setEstoque(newEstoque);
			produtoRepository.save(produto);
			return "Você retirou " + qntToRemove + " do estoque com sucesso. Estoque atual: " + newEstoque;
		}
		produto.setEstoque(0);
		produtoRepository.save(produto);
		int retirados = qntToRemove - (Math.abs(newEstoque));
		return "Você retirou somente " + retirados + " itens do estoque pois não haviam itens o suficiente. O estoque foi zerado";
	}
	
}
