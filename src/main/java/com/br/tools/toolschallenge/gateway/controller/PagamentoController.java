package com.br.tools.toolschallenge.gateway.controller;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.gateway.controller.dto.PagamentoRequest;
import com.br.tools.toolschallenge.usecase.ConsultaPagamento;
import com.br.tools.toolschallenge.usecase.ConsultaPagamentos;
import com.br.tools.toolschallenge.usecase.CriaPagamento;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private CriaPagamento criaPagamento;

    @Autowired
    private ConsultaPagamento consultaPagamento;

    @Autowired
    private ConsultaPagamentos consultaPagamentos;


    @PostMapping
    public ResponseEntity<Object> criaPagamento(@Valid @RequestBody PagamentoRequest request) {
        Pagamento pagamento = criaPagamento.executa(request);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().path("/pagamento/{id}").buildAndExpand(pagamento.getId()).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultaPagamento(@PathVariable("id") Long id) {
        Optional<Pagamento> pagamento = consultaPagamento.executa(id);
        if (pagamento.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagamento.get());
    }

    @GetMapping
    public ResponseEntity<?> consultaPagamentosCancelados() {
        List<PagamentoResponse> pagamentos = consultaPagamentos.executa();
        if (pagamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagamentos);
    }
}
