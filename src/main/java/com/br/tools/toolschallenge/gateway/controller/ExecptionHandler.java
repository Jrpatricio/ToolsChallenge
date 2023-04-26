package com.br.tools.toolschallenge.gateway.controller;

import com.br.tools.toolschallenge.domain.exceptions.PagamentoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExecptionHandler {

    @ExceptionHandler({PagamentoNaoEncontradoException.class})
    public ResponseEntity<?> handlePagamentoNaoEncontradoExecption() {
        return new ResponseEntity<>("Não foi possivel realizar o estorno para o pagamento informado", HttpStatus.BAD_REQUEST);
    }
}
