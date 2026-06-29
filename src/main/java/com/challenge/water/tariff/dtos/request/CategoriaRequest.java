package com.challenge.water.tariff.dtos.request;



import java.util.List;

public record CategoriaRequest(
        Long id, String nome,
        String descricao,
        List<FaixaConsumoRequest> faixas
){}
