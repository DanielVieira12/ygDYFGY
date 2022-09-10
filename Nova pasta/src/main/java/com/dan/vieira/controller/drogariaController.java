package com.dan.vieira.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dan.vieira.domain.produto;
import com.dan.vieira.repository.pprodutoRepository;
import com.dan.vieira.service.recursoNaoEncontradoExeception;

@RestController
@RequestMapping("/drogaria")
public class drogariaController {
	
	@Autowired
	private pprodutoRepository ProdutoRepository;
	
	@GetMapping("/listarPro")
	public List<produto> listar(){
	

		List<produto> Produtos = ProdutoRepository.findAll();
		return Produtos;
	}
	
	@PostMapping
		public produto inserir(@RequestBody produto Produto) {
			
			produto ProdutoIserido = ProdutoRepository.save(Produto);
			return ProdutoIserido;
			
		}
	
	@PutMapping
	public produto Editar(@RequestBody produto Produto) {
		
		produto ProdutoEditado = ProdutoRepository.save(Produto);
		return ProdutoEditado;
	}
	
		@DeleteMapping("/{codigo}")
		public produto delete(@PathVariable  Short codigo) {
	 
	 			Optional<produto> produtoDeletado = ProdutoRepository.findById(codigo);
			ProdutoRepository.delete(produtoDeletado.get());
			
			return produtoDeletado.get();
			
		}
		
	
		
		
		@GetMapping("/{codigo}")
		public produto buscarPorId(@PathVariable Short codigo) {
			try {
			Optional<produto> ProdutoBuscado = ProdutoRepository.findById(codigo);
			return ProdutoBuscado.get();
			
		
		
			    }
			
			catch(recursoNaoEncontradoExeception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ID não encontrado",e); 
			}
		}

	
}
