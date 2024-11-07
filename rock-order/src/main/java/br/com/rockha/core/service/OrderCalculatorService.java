package br.com.rockha.core.service;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.OrderItemsDTO;

@Service
public class OrderCalculatorService implements CommonUseCase<OrderCreateCommand, OrderCreateCommand> {

	@Override
	public OrderCreateCommand process(OrderCreateCommand input) {
		input.setValue(calculateOrderTotal(input));
		return input;
	}

	private BigDecimal calculateOrderTotal(OrderCreateCommand input) {
		return input.getItems().stream().map(this::calculateItemTotal).reduce(ZERO, BigDecimal::add);
	}

	private BigDecimal calculateItemTotal(OrderItemsDTO productOrder) {
		return productOrder.getProduct().getValue().multiply(valueOf(productOrder.getQuantity()));
	}

}
