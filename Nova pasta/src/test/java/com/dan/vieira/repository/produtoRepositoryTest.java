package com.dan.vieira.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dan.vieira.domain.produto;

@SpringBootTest
public class produtoRepositoryTest {

	@Autowired
	private pprodutoRepository produtoRepository;
	
	@Test 
	public void inserir() {
		
		
		
		
		produto p1 = new produto(
				null,
				"cafe", Byte.valueOf("15"),
				LocalDate.of(2022, 8, 23),
				BigDecimal.valueOf(10.50),
				null
				);
	
		
		produto p2 = new produto(
				null,
				"leite", Byte.valueOf("40"),
				LocalDate.of(2023, 8, 23),
				BigDecimal.valueOf(15.50),
				null
				);
	
	
		produtoRepository.save(p1);
		produtoRepository.save(p2);
	}
	
	
	
}
