package br.com.rockha.adapter.inbound.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Pageable;

import br.com.rockha.adapter.inbound.rest.common.CommonRestMapper;
import br.com.rockha.adapter.inbound.rest.request.json.ProductRequestJson;
import br.com.rockha.adapter.inbound.rest.request.parameter.ProductSearchParameter;
import br.com.rockha.adapter.inbound.rest.response.ProductResponseJson;
import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.command.product.ProductDeleteCommand;
import br.com.rockha.core.command.product.ProductFindByIdCommand;
import br.com.rockha.core.command.product.ProductSearchCommand;
import br.com.rockha.core.command.product.ProductUpdateCommand;
import br.com.rockha.core.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductRestMapper extends CommonRestMapper<
        ProductDTO,
        ProductRequestJson,
        ProductRequestJson,
        ProductResponseJson,
        ProductCreateCommand,
        ProductUpdateCommand,
        ProductDeleteCommand,
        ProductFindByIdCommand,
        ProductSearchCommand,
        ProductSearchParameter> {

    @Override
    ProductResponseJson toJson(ProductDTO dto);

    
    ProductCreateCommand toCommand(ProductRequestJson requestJson);

    @Override
    @Mapping(target = "clienteId", source = "requestJson.clienteId")
    @Mapping(target = "atendimentoId", source = "requestJson.atendimentoId")
    @Mapping(target = "data", source = "requestJson.data")
    default ProductUpdateCommand toCommand(String id, ProductRequestJson requestJson) {
        return ProductUpdateCommand.builder()
                .id(id) // Mapeia o ID do Product
                .build();
    }
    

    @Override
    default ProductDeleteCommand toDeleteCommand(String id) {
        return ProductDeleteCommand.builder()
                .id(id)
                .build();
    }

    @Override
    default ProductFindByIdCommand toFindByIdCommand(String id) {
        return ProductFindByIdCommand.builder()
                .id(id)
                .build();
    }

    @Override
    default ProductSearchCommand toSearchCommand(ProductSearchParameter search, Pageable pageable) {
        return ProductSearchCommand.builder()
                .pageable(pageable)
                .build();
    }
}