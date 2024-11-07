package br.com.rockha.adapter.inbound.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Pageable;

import br.com.rockha.adapter.inbound.rest.common.CommonRestMapper;
import br.com.rockha.adapter.inbound.rest.request.json.OrderCreateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.json.OrderUpdateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.json.OrderItemRequestJson;
import br.com.rockha.adapter.inbound.rest.request.parameter.OrderSearchParameter;
import br.com.rockha.adapter.inbound.rest.response.OrderResponseJson;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.dto.OrderItemsDTO;

@Mapper(componentModel = "spring")
public interface OrderRestMapper extends CommonRestMapper<
        OrderDTO,
        OrderCreateRequestJson,
        OrderUpdateRequestJson,
        OrderResponseJson,
        OrderCreateCommand,
        OrderUpdateCommand,
        OrderDeleteCommand,
        OrderFindByIdCommand,
        OrderSearchCommand,
        OrderSearchParameter> {

    @Override
    @Mapping(target = "id", source = "dto.uuid")
    OrderResponseJson toJson(OrderDTO dto);

    
    OrderCreateCommand toCommand(OrderCreateRequestJson requestJson);

    @Override
    @Mapping(target = "clienteId", source = "requestJson.clienteId")
    @Mapping(target = "atendimentoId", source = "requestJson.atendimentoId")
    @Mapping(target = "data", source = "requestJson.data")
    default OrderUpdateCommand toCommand(String id, OrderUpdateRequestJson requestJson) {
        return OrderUpdateCommand.builder()
                .uuid(id) // Mapeia o ID do Order
                .products(toCommand(requestJson.products()))
                .build();
    }
    
    List<OrderItemsDTO> toCommand (List<OrderItemRequestJson> requestJson);

    @Override
    default OrderDeleteCommand toDeleteCommand(String id) {
        return OrderDeleteCommand.builder()
                .uuid(id)
                .build();
    }

    @Override
    default OrderFindByIdCommand toFindByIdCommand(String id) {
        return OrderFindByIdCommand.builder()
                .uuid(id)
                .build();
    }

    @Override
    default OrderSearchCommand toSearchCommand(OrderSearchParameter search, Pageable pageable) {
        return OrderSearchCommand.builder()
                .pageable(pageable)
                .build();
    }
}