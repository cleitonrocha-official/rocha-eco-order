package br.com.rockha.adapter.inbound.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rockha.adapter.inbound.rest.common.CommonCrudRestController;
import br.com.rockha.adapter.inbound.rest.mapper.OrderRestMapper;
import br.com.rockha.adapter.inbound.rest.request.json.OrderCreateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.json.OrderUpdateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.parameter.OrderSearchParameter;
import br.com.rockha.adapter.inbound.rest.response.OrderResponseJson;
import br.com.rockha.core.command.order.OrderCreateCommand;
import br.com.rockha.core.command.order.OrderDeleteCommand;
import br.com.rockha.core.command.order.OrderFindByIdCommand;
import br.com.rockha.core.command.order.OrderSearchCommand;
import br.com.rockha.core.command.order.OrderUpdateCommand;
import br.com.rockha.core.dto.OrderDTO;
import br.com.rockha.core.port.inbound.OrderPortInbound;

@RestController
@RequestMapping("/orders")
public class OrderRestController extends CommonCrudRestController<
        OrderPortInbound, // Porta de entrada específica para Agendamento
        OrderRestMapper,  // Mapper específico para Agendamento
        OrderCreateRequestJson, // Tipo do request para criação
        OrderUpdateRequestJson, // Tipo do request para atualização
        OrderSearchParameter,   // Tipo do parâmetro de busca
        OrderResponseJson,      // Tipo do response JSON
        OrderDTO,               // Tipo do DTO
        OrderCreateCommand,     // Tipo do comando de criação
        OrderUpdateCommand,     // Tipo do comando de atualização
        OrderDeleteCommand,     // Tipo do comando de exclusão
        OrderFindByIdCommand,   // Tipo do comando de busca por ID
        OrderSearchCommand      // Tipo do comando de busca
        >
				{

    public OrderRestController(OrderPortInbound portInbound, OrderRestMapper mapper) {
        super(portInbound, mapper);
    }
}