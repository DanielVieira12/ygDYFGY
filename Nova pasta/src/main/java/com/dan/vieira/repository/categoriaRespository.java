package com.dan.vieira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.vieira.domain.categoria;

public interface categoriaRespository extends JpaRepository<categoria, Short> {

	
}
