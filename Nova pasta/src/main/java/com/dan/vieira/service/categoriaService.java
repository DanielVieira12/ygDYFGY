package com.dan.vieira.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.vieira.domain.categoria;
import com.dan.vieira.repository.categoriaRespository;

@Service
public class categoriaService {

	@Autowired
	private categoriaRespository CategoriaRespository;
	
	public  categoria buscarPorCodigo(Short codigo) {
		
		Optional<categoria>resultado = CategoriaRespository.findById(codigo);
		if(resultado.isEmpty()) {
			throw new recursoNaoEncontradoExeception();
		}
		categoria Categoria = resultado.get();
		return Categoria;
	}
	
	public List<categoria> listar(){
		
	List<categoria> categoria = CategoriaRespository.findAll();
	return categoria;
		
	}
}
