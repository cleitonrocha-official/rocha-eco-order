package br.com.rockha.adapter.inbound.rest.response;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(name = "ProdutoRequest", description = "Objeto que representa um produto no pedido")
public record ProductResponseJson(
	@Schema(type = "string", description = "ID do  Produto", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("id") String id,
	    
	@Schema(type = "string", description = "ID externo do  Produto", example = "12345", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("externalId") String externalId,	
		
    @Schema(type = "string", description = "Nome do produto", example = "Cerveja", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "O nome do produto é obrigatório.")
    @JsonProperty("nome") String name,

    @Schema(type = "number", description = "Valor do produto", example = "14.00", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "O valor do produto é obrigatório.")
    @JsonProperty("valor") BigDecimal value
) {}