package br.com.rockha.adapter.inbound.mq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.rockha.adapter.inbound.mq.payload.OrderCreatePayload;
import br.com.rockha.core.command.order.OrderCreateCommand;

@Mapper(componentModel = "spring")
public interface OrderInboundMqMapper {

	 @Mapping(target = "externalId", source = "orderPayload.id")
    OrderCreateCommand toCommand(OrderCreatePayload orderPayload);

	
}
