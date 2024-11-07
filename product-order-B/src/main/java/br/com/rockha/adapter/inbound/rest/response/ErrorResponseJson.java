package br.com.rockha.adapter.inbound.rest.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.servlet.http.HttpServletRequest;

@Schema(name = "ErrorResponseJson", description = "Estrutura de resposta para erros da API")
public record ErrorResponseJson (
    @Schema(description = "Título do erro", example = "Recurso não encontrado")
    @JsonProperty("titulo") String title,

    @Schema(description = "Mensagem detalhada do erro", example = "O recurso solicitado não foi encontrado no servidor")
    @JsonProperty("mensagem") String message,

    @Schema(description = "Código de status HTTP", example = "404")
    @JsonProperty("status_code") int statusCode,

    @Schema(description = "Timestamp do momento em que o erro ocorreu", example = "2023-10-01T12:34:56")
    @JsonProperty("timestamp") LocalDateTime timestamp,

    @Schema(description = "Caminho da requisição que gerou o erro", example = "/api/v1/usuarios/123")
    @JsonProperty("path") String path
) {
    public ErrorResponseJson(String title, String message, HttpStatus status, HttpServletRequest request) {
        this(title, message, status.value(), LocalDateTime.now(), request.getRequestURI());
    }

    public ErrorResponseJson( String message, HttpStatus status, HttpServletRequest request) {
        this(status.name(), message, status.value(), LocalDateTime.now(), request.getRequestURI());
    }
}