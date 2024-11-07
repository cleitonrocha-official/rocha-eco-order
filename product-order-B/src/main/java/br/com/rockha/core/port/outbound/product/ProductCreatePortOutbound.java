package br.com.rockha.core.port.outbound.product;

import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.ProductDTO;

public interface ProductCreatePortOutbound extends CommonUseCase<ProductDTO, ProductCreateCommand> {
}