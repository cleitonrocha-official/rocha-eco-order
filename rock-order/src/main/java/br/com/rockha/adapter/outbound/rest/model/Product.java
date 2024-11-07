package br.com.rockha.adapter.outbound.rest.model;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Product {

	private String name;
	private BigDecimal value;

}
