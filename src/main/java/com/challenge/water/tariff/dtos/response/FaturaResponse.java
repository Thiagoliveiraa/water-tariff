package com.challenge.water.tariff.dtos.response;

import java.math.BigDecimal;

public record FaturaResponse(
        Integer m3Cobrados, BigDecimal valorUnitario,
        BigDecimal subtotal
){}