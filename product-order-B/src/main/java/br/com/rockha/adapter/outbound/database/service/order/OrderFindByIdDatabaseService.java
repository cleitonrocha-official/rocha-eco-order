package br.com.rockha.adapter.outbound.database.service.order;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonFindByIdDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Order;
import br.com.rockha.adapter.outbound.database.mapper.OrderDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.OrderRepository;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.error.notfound.OrderNaoEncontradoException;
import br.com.rockha.core.port.outbound.order.OrderFindByIdPortOutbound;

@Service
public class OrderFindByIdDatabaseService extends CommonFindByIdDatabaseService<Order, OrderDTO, OrderFindByIdCommand> implements OrderFindByIdPortOutbound {

    public OrderFindByIdDatabaseService(final OrderRepository repository, final OrderDatabaseMapper mapper) {
        super(repository, mapper, OrderNaoEncontradoException::new);
    }
}