package br.com.rockha.core.port.outbound.order;

import org.springframework.data.domain.Page;

import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.OrderDTO;

public interface OrderSearchPortOutbound extends CommonUseCase<Page<OrderDTO>, OrderSearchCommand> {
}