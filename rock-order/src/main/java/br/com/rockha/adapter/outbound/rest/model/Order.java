package br.com.rockha.adapter.outbound.rest.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Order extends CommonEntity {

	private String id;
	private List<OrderItem> items;
	private BigDecimal value;

	public String getUuid() {
		return Optional.ofNullable(id).orElse(super.getUuid());
	}
	
}
