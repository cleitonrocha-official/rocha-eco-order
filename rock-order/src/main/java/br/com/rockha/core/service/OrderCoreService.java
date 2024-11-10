package br.com.rockha.core.service;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.rockha.core.port.outbound.order.ProcessedOrderUploadPortOutbound;
import lombok.Setter;

@Service
@Setter
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

	@Autowired
	private  OrderCalculatorService orderCalculatorService;
	
	@Autowired
	private ProcessedOrderUploadPortOutbound processedOrderUploadPortOutbound;
	 
    public OrderCoreService(
            OrderSearchPortOutbound searchPortOutbound,
            OrderFindByIdPortOutbound findByIdPortOutbound,
            OrderCreatePortOutbound createPortOutbound,
            OrderUpdatePortOutbound updatePortOutbound,
            OrderDeletePortOutbound deletePortOutbound
    ) {
        super(searchPortOutbound, findByIdPortOutbound, createPortOutbound, updatePortOutbound, deletePortOutbound);
        
     
    }
    
    
	@Override
	public OrderDTO create(OrderCreateCommand input) {
		var orderCalculed = orderCalculatorService.process(input);
		var orderDTO = super.create(orderCalculed);
		var orderDTOFull = findByIdPortOutbound.process(OrderFindByIdCommand.builder().uuid(orderDTO.getUuid()).build());
		processedOrderUploadPortOutbound.process(orderDTOFull);
		return orderDTOFull;
	}
}