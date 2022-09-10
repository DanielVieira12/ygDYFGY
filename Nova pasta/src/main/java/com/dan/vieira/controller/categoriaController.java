package com.dan.vieira.controller;

import java.util.List;
//import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dan.vieira.domain.categoria;
//import com.dan.vieira.repository.categoriaRespository;
import com.dan.vieira.service.categoriaService;
import com.dan.vieira.service.recursoNaoEncontradoExeception;

@RestController
@RequestMapping("categoria")
public class categoriaController {
	
	@Autowired
	private categoriaService CategoraService;
	
	@GetMapping
	public List<categoria> listar(){
		
		List<categoria> categorias = CategoraService.listar();
		return categorias;
	}
	
	@GetMapping("/{codigo}")
	public categoria buscarPorCodigo(@PathVariable Short codigo) {
		try {
			categoria Categoria = CategoraService.buscarPorCodigo(codigo);
			return Categoria;
		} catch (recursoNaoEncontradoExeception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Recurso nao encontrado",e);
		}
		
	}
//	
//	@PostMapping
//	public categoria inserir(@RequestBody categoria Categoria) {
//		
//		categoria categoriaSalva = CategoraRepository.save(Categoria);
//		return categoriaSalva;
//	}
	
//	
//	@DeleteMapping("/{codigo}")
//	public categoria delete(@PathVariable Short codigo) {
//		Optional<categoria> Categoria = CategoraRepository.findById(codigo);
//		 CategoraRepository.delete(Categoria.get());
//		return Categoria.get();
//	}
//	
//	@PutMapping
//	public categoria editar(@RequestBody categoria Categoria) {
//		categoria CategoriaEdtidata = CategoraRepository.save(Categoria);
//		return CategoriaEdtidata;
//	}
		
}
