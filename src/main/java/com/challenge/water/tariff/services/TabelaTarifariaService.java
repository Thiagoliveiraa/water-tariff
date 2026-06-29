package com.challenge.water.tariff.services;

import com.challenge.water.tariff.dtos.request.TabelaRequest;
import com.challenge.water.tariff.dtos.response.TabelaTarifariaResponse;

import java.util.List;

public interface TabelaTarifariaService {
    TabelaTarifariaResponse criarTabelaTarifaria(TabelaRequest request);

    void deleteTabelaTarifaria(Long id);

    List<TabelaTarifariaResponse> listarTabelasTarifarias();
}
