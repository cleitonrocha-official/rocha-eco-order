package br.com.rockha.adapter.inbound.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rockha.adapter.inbound.rest.common.CommonCrudRestController;
import br.com.rockha.adapter.inbound.rest.mapper.ProductRestMapper;
import br.com.rockha.adapter.inbound.rest.request.json.ProductRequestJson;
import br.com.rockha.adapter.inbound.rest.request.parameter.ProductSearchParameter;
import br.com.rockha.adapter.inbound.rest.response.ProductResponseJson;
import br.com.rockha.core.command.product.ProductCreateCommand;
import br.com.rockha.core.command.product.ProductDeleteCommand;
import br.com.rockha.core.command.product.ProductFindByIdCommand;
import br.com.rockha.core.command.product.ProductSearchCommand;
import br.com.rockha.core.command.product.ProductUpdateCommand;
import br.com.rockha.core.dto.ProductDTO;
import br.com.rockha.core.port.inbound.ProductPortInbound;

@RestController
@RequestMapping("/Products")
public class ProductRestController extends CommonCrudRestController<
        ProductPortInbound, // Porta de entrada específica para Agendamento
        ProductRestMapper,  // Mapper específico para Agendamento
        ProductRequestJson, // Tipo do request para criação
        ProductRequestJson, // Tipo do request para atualização
        ProductSearchParameter,   // Tipo do parâmetro de busca
        ProductResponseJson,      // Tipo do response JSON
        ProductDTO,               // Tipo do DTO
        ProductCreateCommand,     // Tipo do comando de criação
        ProductUpdateCommand,     // Tipo do comando de atualização
        ProductDeleteCommand,     // Tipo do comando de exclusão
        ProductFindByIdCommand,   // Tipo do comando de busca por ID
        ProductSearchCommand      // Tipo do comando de busca
        > 
				{

    public ProductRestController(ProductPortInbound portInbound, ProductRestMapper mapper) {
        super(portInbound, mapper);
    }
}