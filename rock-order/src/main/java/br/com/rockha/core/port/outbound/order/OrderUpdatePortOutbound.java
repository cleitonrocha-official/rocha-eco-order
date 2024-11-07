package br.com.rockha.core.port.outbound.order;

import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.OrderDTO;

public interface OrderUpdatePortOutbound extends CommonUseCase<OrderDTO, OrderUpdateCommand> {
}