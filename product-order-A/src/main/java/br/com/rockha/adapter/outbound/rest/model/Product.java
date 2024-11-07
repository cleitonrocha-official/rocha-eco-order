package br.com.rockha.adapter.outbound.rest.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Product {

	@JsonProperty("nome")
	private String name;
	@JsonProperty("valor")
	private BigDecimal value;

}
