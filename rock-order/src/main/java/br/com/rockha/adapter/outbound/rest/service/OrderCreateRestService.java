package br.com.rockha.adapter.outbound.rest.service;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.rest.client.OrderRestRepository;
import br.com.rockha.adapter.outbound.rest.mapper.OrderOutboundRestMapper;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderCreatePortOutbound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCreateRestService implements OrderCreatePortOutbound {

	
	private final OrderRestRepository restRepository;
	private final OrderOutboundRestMapper mapper;
	
	@Override
	public OrderDTO process(OrderCreateCommand command) {
		var model = mapper.toModel(command);
		var  order = restRepository.create(model).getBody();
		log.info("order id = {}",order.getUuid());
		return mapper.toDto(order);
		
	}

}
