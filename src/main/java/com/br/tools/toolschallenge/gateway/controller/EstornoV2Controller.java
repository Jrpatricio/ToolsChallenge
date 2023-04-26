package com.br.tools.toolschallenge.gateway.controller;

import com.br.tools.toolschallenge.usecase.CriaEstorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/estorno")
public class EstornoV2Controller {

    @Autowired
    private CriaEstorno criaEstorno;

    @PatchMapping("{id}")
    public ResponseEntity<Object> criaEstorno(@PathVariable("id") Long pagamentoId) {
        criaEstorno.executa(pagamentoId);
        return ResponseEntity.ok().build();
    }
}
