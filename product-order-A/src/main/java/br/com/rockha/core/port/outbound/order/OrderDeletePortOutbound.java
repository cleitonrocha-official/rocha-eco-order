package br.com.rockha.core.port.outbound.order;

import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;

public interface OrderDeletePortOutbound extends CommonUseCase<Void, OrderDeleteCommand> {
}