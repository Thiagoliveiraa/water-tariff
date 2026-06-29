package com.challenge.water.tariff.dtos.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record CalculoRequest(
        @NotNull String categoria,
        @NotNull @Min(0) Integer consumo
){}
