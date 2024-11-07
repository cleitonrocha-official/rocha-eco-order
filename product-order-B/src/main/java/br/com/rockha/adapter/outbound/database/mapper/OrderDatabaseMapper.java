package br.com.rockha.adapter.outbound.database.mapper;

import org.mapstruct.Mapper;

import br.com.rockha.adapter.outbound.database.common.CommonDatabaseMapper;
import br.com.rockha.adapter.outbound.database.entity.Order;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderDatabaseMapper extends CommonDatabaseMapper<Order, OrderDTO, OrderCreateCommand> {
}