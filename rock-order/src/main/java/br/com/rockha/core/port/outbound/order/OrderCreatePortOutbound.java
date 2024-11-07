package br.com.rockha.core.port.outbound.order;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.OrderDTO;

public interface OrderCreatePortOutbound extends CommonUseCase<OrderDTO, OrderCreateCommand> {
}