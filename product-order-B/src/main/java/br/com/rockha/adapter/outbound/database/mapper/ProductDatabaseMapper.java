package br.com.rockha.adapter.outbound.database.mapper;

import org.mapstruct.Mapper;

import br.com.rockha.adapter.outbound.database.common.CommonDatabaseMapper;
import br.com.rockha.adapter.outbound.database.entity.Product;
import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductDatabaseMapper extends CommonDatabaseMapper<Product, ProductDTO, ProductCreateCommand> {
}