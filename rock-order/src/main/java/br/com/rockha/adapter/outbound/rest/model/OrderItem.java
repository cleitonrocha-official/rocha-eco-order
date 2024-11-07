package br.com.rockha.adapter.outbound.rest.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class OrderItem extends CommonEntity {

	private Product product;
	private Integer quantity;

}
