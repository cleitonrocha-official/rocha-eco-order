package br.com.rockha.adapter.inbound.rest.controller.doc;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rockha.adapter.inbound.rest.request.json.OrderCreateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.json.OrderUpdateRequestJson;
import br.com.rockha.adapter.inbound.rest.request.parameter.OrderSearchParameter;
import br.com.rockha.adapter.inbound.rest.response.ErrorResponseJson;
import br.com.rockha.adapter.inbound.rest.response.OrderResponseJson;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Order API", description = "API para gerenciamento de pedidos")
public interface OrderRestControllerDoc {

    @Operation(summary = "Cria um novo pedido",
        responses = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
                content = @Content(schema = @Schema(implementation = OrderCreateRequestJson.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                content = @Content(schema = @Schema(implementation = ErrorResponseJson.class)))
        })
    @PostMapping
    ResponseEntity<OrderResponseJson> create(
        @Parameter(description = "Dados para criação do pedido", required = true)
        @Valid @RequestBody OrderCreateRequestJson requestJson);

    @Operation(summary = "Deleta um pedido pelo ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Pedido deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
                content = @Content(schema = @Schema(implementation = ErrorResponseJson.class)))
        })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(
        @Parameter(description = "ID do pedido", required = true)
        @PathVariable String id);

    @Operation(summary = "Busca um pedido pelo ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado",
                content = @Content(schema = @Schema(implementation = OrderResponseJson.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
                content = @Content(schema = @Schema(implementation = ErrorResponseJson.class)))
        })
    @GetMapping("/{id}")
    ResponseEntity<OrderResponseJson> findById(
        @Parameter(description = "ID do pedido", required = true)
        @PathVariable String id);

    @Operation(summary = "Atualiza um pedido pelo ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Pedido atualizado com sucesso",
                content = @Content(schema = @Schema(implementation = OrderResponseJson.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos",
                content = @Content(schema = @Schema(implementation = ErrorResponseJson.class))),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado",
                content = @Content(schema = @Schema(implementation = ErrorResponseJson.class)))
        })
    @PatchMapping("/{id}")
    ResponseEntity<OrderResponseJson> update(
        @Parameter(description = "ID do pedido", required = true)
        @PathVariable String id,
        @Parameter(description = "Dados para atualização do pedido", required = true)
        @Valid @RequestBody OrderUpdateRequestJson requestJson);

    @Operation(summary = "Busca uma lista paginada de pedidos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos retornada com sucesso",
                content = @Content(schema = @Schema(implementation = Page.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros de paginação inválidos",
                content = @Content(schema = @Schema(implementation = ErrorResponseJson.class)))
        })
    @GetMapping
    ResponseEntity<Page<OrderResponseJson>> search(
        @Parameter(description = "Parâmetros de busca para pedidos", required = false,
            schema = @Schema(implementation = OrderSearchParameter.class))
        OrderSearchParameter searchParameter,
        @Parameter(description = "Parâmetros de paginação", required = false)
        Pageable pageable);
}