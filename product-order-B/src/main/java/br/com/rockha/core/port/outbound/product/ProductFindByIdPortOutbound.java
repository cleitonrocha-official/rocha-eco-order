package br.com.rockha.core.port.outbound.product;

import br.com.rockha.core.command.product.ProductFindByIdCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.ProductDTO;

public interface ProductFindByIdPortOutbound extends CommonUseCase<ProductDTO, ProductFindByIdCommand> {
}