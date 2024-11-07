package br.com.rockha.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Product {

	@Column(name = "nome")
	private String name;
	@Column(name = "valor")
	private BigDecimal value;

}
