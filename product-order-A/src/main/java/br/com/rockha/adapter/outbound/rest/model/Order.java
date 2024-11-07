package br.com.rockha.adapter.outbound.rest.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order  {

	private String id;
	private List<OrderItem> items;

}
