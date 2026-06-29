package com.challenge.water.tariff.dtos.response;


import java.math.BigDecimal;
import java.util.List;

public record CalculoResponse(
        String categoria,
        Integer consumoTotal,
        BigDecimal valorTotal,
        List<DetalheFaixaResponse> detalhamento
) {}


