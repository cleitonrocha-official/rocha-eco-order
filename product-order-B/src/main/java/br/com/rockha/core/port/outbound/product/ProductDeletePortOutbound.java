package br.com.rockha.core.port.outbound.product;

import br.com.rockha.core.command.product.ProductDeleteCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;

public interface ProductDeletePortOutbound extends CommonUseCase<Void, ProductDeleteCommand> {
}