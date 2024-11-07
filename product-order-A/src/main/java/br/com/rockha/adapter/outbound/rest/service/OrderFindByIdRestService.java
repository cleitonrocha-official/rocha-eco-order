package br.com.rockha.adapter.outbound.rest.service;

import org.springframework.stereotype.Service;

import br.com.rockha.adapter.outbound.rest.client.OrderRestRepository;
import br.com.rockha.adapter.outbound.rest.mapper.OrderOutboundRestMapper;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderFindByIdPortOutbound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderFindByIdRestService implements OrderFindByIdPortOutbound {


	private final OrderRestRepository restRepository;
	private final OrderOutboundRestMapper mapper;
	
	@Override
	public OrderDTO process(OrderFindByIdCommand command) {

		var  order = restRepository.getById(command.getId()).getBody();
		return mapper.toDto(order);
		
	}
}
