package br.com.rockha.adapter.outbound.database.service.order;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonUpdateDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Order;
import br.com.rockha.adapter.outbound.database.mapper.OrderDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.OrderRepository;
import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.error.notfound.OrderNaoEncontradoException;
import br.com.rockha.core.port.outbound.order.OrderUpdatePortOutbound;

@Service
public class OrderUpdateDatabaseService extends CommonUpdateDatabaseService<Order, OrderDTO, OrderUpdateCommand> implements OrderUpdatePortOutbound {

    public OrderUpdateDatabaseService(
            final OrderRepository repository,
            final OrderDatabaseMapper mapper) {
        super(repository, mapper, OrderNaoEncontradoException::new);
    }

    @Override
    public void patch(Order Order, OrderUpdateCommand command) {
    }
}