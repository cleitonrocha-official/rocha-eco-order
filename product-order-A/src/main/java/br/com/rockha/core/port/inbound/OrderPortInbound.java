package br.com.rockha.core.port.inbound;

import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.common.adapter.adapter.CommonCrudAdapterPortInbound;
import br.com.rockha.core.dto.OrderDTO;

public interface OrderPortInbound extends CommonCrudAdapterPortInbound<
    OrderDTO,
    OrderCreateCommand,
    OrderUpdateCommand,
    OrderDeleteCommand,
    OrderFindByIdCommand,
    OrderSearchCommand> {
}