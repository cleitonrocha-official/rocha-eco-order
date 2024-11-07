package br.com.rockha.adapter.outbound.rest.service;

import org.springframework.stereotype.Service;

import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.port.outbound.order.OrderDeletePortOutbound;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderDeleteRestService implements OrderDeletePortOutbound {

	@Override
	public Void process(OrderDeleteCommand command) {
		log.info("deletou");
		return null;
	}

}
