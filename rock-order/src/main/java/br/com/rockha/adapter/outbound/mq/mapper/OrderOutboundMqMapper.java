package br.com.rockha.adapter.outbound.mq.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.rockha.adapter.outbound.mq.payload.OrderProcessedUploadPayload;
import br.com.rockha.core.dto.OrderDTO;


@Mapper(componentModel = "spring")
public interface OrderOutboundMqMapper {

	 @Mapping(target = "id", source = "dto.uuid")
    OrderProcessedUploadPayload toPayload(OrderDTO dto);

	
}
