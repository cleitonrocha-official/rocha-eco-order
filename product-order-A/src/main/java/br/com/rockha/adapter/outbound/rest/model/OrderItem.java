package br.com.rockha.adapter.outbound.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItem  {

	@JsonProperty("produto")
	private Product product;
	@JsonProperty("quantidade")
	private Integer quantity;

}
