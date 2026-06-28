package com.challenge.water.tariff.dtos.response;

import java.math.BigDecimal;

public record FaixaConsumoResponse(
        Integer inicio, Integer fim,
        BigDecimal valorUnitario
) {}
