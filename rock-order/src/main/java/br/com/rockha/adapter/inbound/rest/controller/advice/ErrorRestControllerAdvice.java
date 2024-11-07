package br.com.rockha.adapter.inbound.rest.controller.advice;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rockha.adapter.inbound.rest.response.ErrorResponseJson;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorRestControllerAdvice {

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<ErrorResponseJson> handler(PropertyReferenceException ex, HttpServletRequest request) {
        log.error("Exceção capturada no método: {}. Mensagem: {}", ex.getStackTrace()[0].getMethodName(), ex.getMessage());
        var badRequestStatusCode = HttpStatus.BAD_REQUEST;
        ErrorResponseJson errorResponseJson = new ErrorResponseJson(ex.getMessage(), badRequestStatusCode, request);
        return new ResponseEntity<>(errorResponseJson, badRequestStatusCode);
    }

}

