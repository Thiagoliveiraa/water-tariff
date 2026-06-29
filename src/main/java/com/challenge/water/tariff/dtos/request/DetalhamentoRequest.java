package com.challenge.water.tariff.dtos.request;

import com.challenge.water.tariff.entities.Categoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetalhamentoRequest(
        @NotNull CategoriaRequest categoria,
        @NotNull @NotEmpty @Valid List<FaixaConsumoRequest> faixasConsumo
        ) {
}
