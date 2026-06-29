package com.challenge.water.tariff.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TabelaRequest(
        @NotBlank String nome,
        @NotNull LocalDate dataVigenciaInicio,
        LocalDate dataVigenciaFim,
        List<CategoriaRequest> categorias
){}
