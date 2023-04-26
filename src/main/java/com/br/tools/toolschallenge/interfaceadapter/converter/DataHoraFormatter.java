package com.br.tools.toolschallenge.interfaceadapter.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataHoraFormatter {
    public static String formata(LocalDateTime data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return data.format(formatter);
    }
}
