package br.com.rockha.adapter.outbound.rest.mapper;

import org.mapstruct.Mapper;

import br.com.rockha.adapter.outbound.rest.model.Order;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderOutboundRestMapper {

	Order toModel(OrderCreateCommand dto);
	OrderDTO toDto(Order order);
	
	
}
