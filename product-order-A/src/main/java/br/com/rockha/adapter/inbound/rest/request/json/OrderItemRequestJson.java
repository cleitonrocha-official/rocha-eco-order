package br.com.rockha.adapter.inbound.rest.request.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(name = "ProdutoPedidoRequest", description = "Objeto que representa um produto e seus detalhes no pedido")
public record OrderItemRequestJson(
    @Schema(type = "object", description = "Produto", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "O produto é obrigatório.")
    @JsonProperty("produto") ProductRequestJson product,

    @Schema(type = "integer", description = "Quantidade do produto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "A quantidade é obrigatória.")
    @JsonProperty("quantidade") Integer quantity

) {}