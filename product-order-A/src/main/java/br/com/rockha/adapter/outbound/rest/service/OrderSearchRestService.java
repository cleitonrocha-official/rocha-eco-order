package br.com.rockha.adapter.outbound.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.outbound.order.OrderSearchPortOutbound;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderSearchRestService implements OrderSearchPortOutbound {

	@Override
	public Page<OrderDTO> process(OrderSearchCommand command) {
		log.info("buscou");
		return Page.empty();
	}

}
