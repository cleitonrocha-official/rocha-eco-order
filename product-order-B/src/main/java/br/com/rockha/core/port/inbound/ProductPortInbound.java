package br.com.rockha.core.port.inbound;

import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.command.product.ProductDeleteCommand;
import br.com.rockha.core.command.product.ProductFindByIdCommand;
import br.com.rockha.core.command.product.ProductSearchCommand;
import br.com.rockha.core.command.product.ProductUpdateCommand;
import br.com.rockha.core.common.adapter.adapter.CommonCrudAdapterPortInbound;
import br.com.rockha.core.dto.ProductDTO;

public interface ProductPortInbound extends CommonCrudAdapterPortInbound<
   ProductDTO,
   ProductCreateCommand,
   ProductUpdateCommand,
   ProductDeleteCommand,
   ProductFindByIdCommand,
   ProductSearchCommand> {
}