package br.com.rockha.core.service;

import org.springframework.stereotype.Service;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.common.CommonCrudCoreService;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.inbound.OrderPortInbound;
import br.com.rockha.core.port.outbound.order.OrderCreatePortOutbound;
import br.com.rockha.core.port.outbound.order.OrderDeletePortOutbound;
import br.com.rockha.core.port.outbound.order.OrderFindByIdPortOutbound;
import br.com.rockha.core.port.outbound.order.OrderSearchPortOutbound;
import br.com.rockha.core.port.outbound.order.OrderUpdatePortOutbound;

@Service
public class OrderCoreService extends CommonCrudCoreService<
		OrderDTO,
        OrderCreateCommand,
        OrderUpdateCommand,
        OrderDeleteCommand,
        OrderFindByIdCommand,
        OrderSearchCommand,
        OrderSearchPortOutbound,
        OrderFindByIdPortOutbound,
        OrderCreatePortOutbound,
        OrderUpdatePortOutbound,
        OrderDeletePortOutbound
    > implements OrderPortInbound {

    public OrderCoreService(
            OrderSearchPortOutbound searchPortOutbound,
            OrderFindByIdPortOutbound findByIdPortOutbound,
            OrderCreatePortOutbound createPortOutbound,
            OrderUpdatePortOutbound updatePortOutbound,
            OrderDeletePortOutbound deletePortOutbound
    ) {
        super(searchPortOutbound, findByIdPortOutbound, createPortOutbound, updatePortOutbound, deletePortOutbound);
        
     
    }
    
    
}