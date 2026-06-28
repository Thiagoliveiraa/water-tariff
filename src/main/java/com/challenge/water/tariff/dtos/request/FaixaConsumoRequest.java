package com.challenge.water.tariff.dtos.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record FaixaConsumoRequest(
        @NotNull @Min(0) Integer faixaInicio,
        @NotNull @Min(1) Integer faixaFim,
        @NotNull @DecimalMin("0.0001") BigDecimal valorUnitario
) {}
