package br.com.rockha.adapter.outbound.rest.service;

import org.springframework.stereotype.Service;

import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderUpdatePortOutbound;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderUpdateRestService implements OrderUpdatePortOutbound {

	@Override
	public OrderDTO process(OrderUpdateCommand command) {
		log.info("buscou");
		return null;
	}


}
