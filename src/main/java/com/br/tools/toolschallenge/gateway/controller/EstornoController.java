package com.br.tools.toolschallenge.gateway.controller;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.domain.types.Status;
import com.br.tools.toolschallenge.interfaceadapter.converter.PagamentoConverter;
import com.br.tools.toolschallenge.usecase.CancelaPagamento;
import com.br.tools.toolschallenge.usecase.ConsultaPagamento;
import com.br.tools.toolschallenge.usecase.ConsultaPagamentos;
import com.br.tools.toolschallenge.usecase.dto.PagamentoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estorno")
public class EstornoController {

    @Autowired
    private ConsultaPagamentos consultaPagamentos;

    @Autowired
    private ConsultaPagamento consultaPagamento;

    @Autowired
    private CancelaPagamento cancelaPagamento;

    @Autowired
    private PagamentoConverter converter;


    @PatchMapping("/{id}")
    public ResponseEntity<Object> estornaPagamento(@PathVariable("id") Long id) {
        cancelaPagamento.executa(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> consultaPagamento(@PathVariable("id") Long id){
        Optional<Pagamento> pagamento = consultaPagamento.executa(id, Status.CANCELADO);
        if (pagamento.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(converter.executa(pagamento.get()));
    }

    @GetMapping
    public ResponseEntity<Object> consultaPagamentosCancelados() {
        List<PagamentoResponse> pagamentos = consultaPagamentos.executa(Status.CANCELADO);
        if (pagamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagamentos);
    }

}
