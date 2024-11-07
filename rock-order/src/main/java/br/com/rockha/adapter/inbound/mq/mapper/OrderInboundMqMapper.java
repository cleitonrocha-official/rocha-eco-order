package br.com.rockha.adapter.inbound.mq.mapper;

import org.mapstruct.Mapper;

import br.com.rockha.adapter.inbound.mq.payload.OrderCreatePayload;
import br.com.rockha.core.command.order.OrderCreateCommand;

@Mapper(componentModel = "spring")
public interface OrderInboundMqMapper {

    OrderCreateCommand toCommand(OrderCreatePayload orderPayload);

	
}
