package br.com.rockha.adapter.outbound.database.service.order;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonDeleteDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Order;
import br.com.rockha.adapter.outbound.database.repository.OrderRepository;
import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.error.notfound.OrderNaoEncontradoException;
import br.com.rockha.core.port.outbound.order.OrderDeletePortOutbound;

@Service
public class OrderDeleteDatabaseService
        extends CommonDeleteDatabaseService<Order, OrderDeleteCommand>
        implements OrderDeletePortOutbound {

    public OrderDeleteDatabaseService(final OrderRepository repository) {
        super(repository, OrderNaoEncontradoException::new);
    }
}