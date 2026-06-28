package com.challenge.water.tariff.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TabelaTarifariaRequest(
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotNull LocalDate dataVigenciaInicio,
        LocalDate dataVigenciaFim,
        @NotNull @NotEmpty @Valid List<CategoriaRequest> categorias
) {
    //TODO: criar o construtor do record para prevenir lista nula e imutavel!
}
