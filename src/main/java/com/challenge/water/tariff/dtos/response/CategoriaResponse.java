package com.challenge.water.tariff.dtos.response;

import com.challenge.water.tariff.entities.Categoria;

import java.util.List;

public record CategoriaResponse(
        Long id, String categoria,
        List<FaixaConsumoResponse> faixasConsumo
){}
