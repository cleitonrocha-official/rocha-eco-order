package br.com.rockha.adapter.outbound.database.service.order;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonCreateDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Order;
import br.com.rockha.adapter.outbound.database.mapper.OrderDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.OrderRepository;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderCreatePortOutbound;

@Service
public class OrderCreateDatabaseService extends CommonCreateDatabaseService<Order, OrderDTO, OrderCreateCommand> implements OrderCreatePortOutbound {

    public OrderCreateDatabaseService(final OrderRepository repository, final OrderDatabaseMapper mapper) {
        super(repository, mapper);
    }
}