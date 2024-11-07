package br.com.rockha.adapter.inbound.rest.request.parameter;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PedidoSearchParameter", description = "Parâmetros de busca para produto")
public record ProductSearchParameter(
) {}