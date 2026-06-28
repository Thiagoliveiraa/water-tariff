package com.challenge.water.tariff.dtos.response;

import com.challenge.water.tariff.entities.Categoria;

import java.math.BigDecimal;
import java.util.List;

public record CalculoResponse(
        Categoria categoria,
        Integer consumoTotal,
        BigDecimal valorTotal,
        List<DetalheFaixaResponse> detalhamento
) {
}
