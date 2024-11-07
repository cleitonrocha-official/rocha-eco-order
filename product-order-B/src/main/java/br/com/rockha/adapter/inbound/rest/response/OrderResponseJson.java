package br.com.rockha.adapter.inbound.rest.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(name = "PedidoResponseJson", description = "Estrutura de resposta para os dados de um pedido")
public record OrderResponseJson(
		    @Schema(type = "string", description = "ID do  Pedido", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
		    @JsonProperty("id") String id,
		    
		    @Schema(type = "string", description = "ID Externo do  Pedido", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
		    @JsonProperty("externalId") String externalId,

		    @Schema(type = "array", description = "Lista de produtos e seus detalhes no pedido", requiredMode = Schema.RequiredMode.REQUIRED)
		    @NotNull(message = "A lista de produtos é obrigatória.")
		    @JsonProperty("items") List<OrderItemResponseJson> items,
		    
		    @Schema(type = "number", description = "Valor do pedido", requiredMode = Schema.RequiredMode.REQUIRED)
		    @NotNull(message = "A lista de produtos é obrigatória.")
		    @JsonProperty("valor") BigDecimal value
) {}