package com.challenge.water.tariff.dtos.request;

import com.challenge.water.tariff.entities.Categoria;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record CalculoRequest(
        @NotNull Categoria categoria,
        @NotNull @Min(1) Integer consumo
) {}
