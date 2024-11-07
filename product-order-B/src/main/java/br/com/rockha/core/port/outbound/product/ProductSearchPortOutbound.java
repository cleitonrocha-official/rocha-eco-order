package br.com.rockha.core.port.outbound.product;

import org.springframework.data.domain.Page;

import br.com.rockha.core.command.product.ProductSearchCommand;
import br.com.rockha.core.common.adapter.adapter.CommonUseCase;
import br.com.rockha.core.dto.ProductDTO;

public interface ProductSearchPortOutbound extends CommonUseCase<Page<ProductDTO>, ProductSearchCommand> {
}