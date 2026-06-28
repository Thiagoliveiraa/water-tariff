package com.challenge.water.tariff.dtos.request;

import com.challenge.water.tariff.entities.Categoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CategoriaRequest(
        @NotNull Categoria categoria,
        @NotNull @NotEmpty @Valid List<FaixaConsumoRequest> faixasConsumo
        ) {
    //TODO: criar o construtor do record para prevenir lista nula e imutavel!
}
