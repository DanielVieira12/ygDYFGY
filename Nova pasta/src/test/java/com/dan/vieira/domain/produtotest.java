package com.dan.vieira.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class produtotest {

	@Test
	public void criar() {
		
	produto p = new produto(Short.valueOf("1"),"cafe", Byte.valueOf("15"),LocalDate.of(2022, 8, 23),BigDecimal.valueOf(10.50),null);
	System.out.println(p);
	}
	
	
}
