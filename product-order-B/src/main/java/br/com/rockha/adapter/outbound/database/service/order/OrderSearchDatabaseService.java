package br.com.rockha.adapter.outbound.database.service.order;

import java.util.ArrayList;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.database.common.crud.CommonSearchDatabaseService;
import br.com.rockha.adapter.outbound.database.entity.Order;
import br.com.rockha.adapter.outbound.database.mapper.OrderDatabaseMapper;
import br.com.rockha.adapter.outbound.database.repository.OrderRepository;
import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderSearchPortOutbound;
import jakarta.persistence.criteria.Predicate;

@Service
public class OrderSearchDatabaseService extends CommonSearchDatabaseService<Order, OrderSearchCommand, OrderDTO> implements OrderSearchPortOutbound {

    public OrderSearchDatabaseService(final OrderRepository repository, final OrderDatabaseMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Specification<Order> byCriteria(OrderSearchCommand command) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

       //implementar filtro

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}