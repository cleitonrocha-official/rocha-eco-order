package br.com.rockha.adapter.inbound.rest.request.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(name = "PedidoCreateRequest", description = "Objeto de requisição para criar um novo Pedido")
public record OrderCreateRequestJson(

    @Schema(type = "array", description = "Lista de produtos e seus detalhes no pedido", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "A lista de produtos é obrigatória.")
    @JsonProperty("items") List<OrderItemRequestJson> items
) {}