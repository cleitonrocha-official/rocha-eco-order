package br.com.rockha.core.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.common.CommonCrudCoreService;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.error.invalidarg.OrderCreateException;
import br.com.rockha.core.port.inbound.OrderPortInbound;
import br.com.rockha.core.port.outbound.order.OrderCreatePortOutbound;
import br.com.rockha.core.port.outbound.order.OrderDeletePortOutbound;
import br.com.rockha.core.port.outbound.order.OrderFindByIdPortOutbound;
import br.com.rockha.core.port.outbound.order.OrderSearchPortOutbound;
import br.com.rockha.core.port.outbound.order.OrderUpdatePortOutbound;
import br.com.rockha.core.port.outbound.order.ProcessedOrderUploadPortOutbound;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Setter
@Slf4j
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
		 return Optional.of(input)
			        .map(orderCalculatorService::process)
			        .map(super::create) 
			        .map(this::buildFindByCommand) 
			        .map(findByIdPortOutbound::process)
			        .map(this::uploadOrder)
			        .orElseThrow(OrderCreateException::new); 
	}


	private OrderDTO uploadOrder(OrderDTO orderDTOFull) {
		processedOrderUploadPortOutbound.process(orderDTOFull); 
		return orderDTOFull;
	}


	private OrderFindByIdCommand buildFindByCommand(OrderDTO orderDTO) {
		return OrderFindByIdCommand.builder().uuid(orderDTO.getUuid()).build();
	}
}