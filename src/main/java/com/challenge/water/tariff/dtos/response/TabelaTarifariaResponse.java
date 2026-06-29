package com.challenge.water.tariff.dtos.response;

import java.time.LocalDate;
import java.util.List;

public record TabelaTarifariaResponse(
        Long id, String nome,
        LocalDate dataVigenciaInicio, LocalDate dataVigenciaFim,
        List<CategoriaResponse> categorias
) {}
