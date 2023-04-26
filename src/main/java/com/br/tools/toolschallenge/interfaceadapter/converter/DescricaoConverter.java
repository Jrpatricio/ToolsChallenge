package com.br.tools.toolschallenge.interfaceadapter.converter;

import com.br.tools.toolschallenge.domain.Pagamento;
import com.br.tools.toolschallenge.usecase.dto.DescricaoResponse;
import org.springframework.stereotype.Component;

@Component
public class DescricaoConverter {

    public DescricaoResponse executa(Pagamento pagamento) {
        DescricaoResponse descricaoResponse = new DescricaoResponse();
        descricaoResponse.setValor(pagamento.getValor().toString());
        descricaoResponse.setDataHora(DataHoraFormatter.formata(pagamento.getDataHora()));
        descricaoResponse.setEstabelecimento(pagamento.getEstabelecimento());
        descricaoResponse.setNsu(pagamento.getNsu());
        descricaoResponse.setCodigoAutorizacao(pagamento.getCodigoAutorizacao());
        descricaoResponse.setStatus(pagamento.getStatus());
        return descricaoResponse;
    }
}
