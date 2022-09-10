package com.dan.vieira.domain;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity  
@Table(name="tb_drogaria")
public class produto  {
	
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Short codigo;
		
		@Column(length=30, nullable=false, unique=true)
		private String nome;
		
		@Column(nullable=false)
		private Byte quantidade;
		
		@Column()
		private LocalDate validade;
		
		@Column(nullable=false, precision=5, scale=2)
		private BigDecimal preco;
		
		@ManyToOne
		@JoinColumn(nullable=true)
		private categoria categoria;


	

	
	
	
	
}
