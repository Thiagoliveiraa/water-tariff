package com.challenge.water.tariff.services.impl;

import com.challenge.water.tariff.dtos.request.CategoriaRequest;
import com.challenge.water.tariff.dtos.request.FaixaConsumoRequest;
import com.challenge.water.tariff.dtos.request.TabelaRequest;
import com.challenge.water.tariff.dtos.response.CategoriaResponse;
import com.challenge.water.tariff.dtos.response.FaixaConsumoResponse;
import com.challenge.water.tariff.dtos.response.TabelaTarifariaResponse;
import com.challenge.water.tariff.entities.Categoria;
import com.challenge.water.tariff.entities.FaixaConsumo;
import com.challenge.water.tariff.entities.TabelaTarifaria;
import com.challenge.water.tariff.exceptions.ResourceNotFoundException;
import com.challenge.water.tariff.repositories.TabelaTarifariaRepository;
import com.challenge.water.tariff.services.TabelaTarifariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TabelaTarifariaServiceImpl implements TabelaTarifariaService {
    private final TabelaTarifariaRepository tabelaTarifariaRepository;

    @Autowired
    public TabelaTarifariaServiceImpl(TabelaTarifariaRepository tabelaTarifariaRepository) {
        this.tabelaTarifariaRepository = tabelaTarifariaRepository;
    }


    @Override
    @Transactional
    public TabelaTarifariaResponse criarTabelaTarifaria(TabelaRequest request) {
        TabelaTarifaria tabela = new TabelaTarifaria();
        tabela.setNome(request.nome());
        tabela.setDataVigenciaInicio(request.dataVigenciaInicio());
        tabela.setDataVigenciaFim(request.dataVigenciaFim());

        if (request.categorias() != null) {
            for (CategoriaRequest catRequest : request.categorias()) {
                Categoria categoria = new Categoria();
                categoria.setNome(catRequest.nome());

                if (catRequest.faixas() != null) {
                    for (FaixaConsumoRequest faixaRequest : catRequest.faixas()) {
                        FaixaConsumo faixa = new FaixaConsumo();
                        faixa.setFaixaInicial(faixaRequest.faixaInicio());
                        faixa.setFaixaFinal(faixaRequest.faixaFim());
                        faixa.setValorUnitario(faixaRequest.valorUnitario());
                        categoria.addFaixa(faixa);
                    }
                }
                tabela.addCategoria(categoria);
            }
        }

        TabelaTarifaria tabelaSalva = tabelaTarifariaRepository.save(tabela);

        return toResponseApartirDaMemoria(tabelaSalva);
    }

    @Override
    @Transactional
    public void deleteTabelaTarifaria(Long id) {
        TabelaTarifaria tabelaTarifaria = tabelaTarifariaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Tabela Tarifária não encontrada: " + id)
        );
        tabelaTarifariaRepository.delete(tabelaTarifaria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TabelaTarifariaResponse> listarTabelasTarifarias() {
        List<TabelaTarifaria> tabelaTarifarias = tabelaTarifariaRepository.findAllWithCategorias();

        if (!tabelaTarifarias.isEmpty()) {
            tabelaTarifariaRepository.fetchFaixasParaCategorias(tabelaTarifarias);
        }

        return tabelaTarifarias.stream()
                .map(this::toTabelaTarifariaResponse)
                .toList();
    }


    private TabelaTarifariaResponse toResponseApartirDaMemoria(TabelaTarifaria tabela) {
        List<CategoriaResponse> categoriasResponse = new ArrayList<>();

        for (Categoria categoria : tabela.getCategorias()) {
            List<FaixaConsumoResponse> faixasResponse = new ArrayList<>();
            for (FaixaConsumo faixa : categoria.getFaixas()) {
                faixasResponse.add(new FaixaConsumoResponse(faixa.getFaixaInicial(), faixa.getFaixaFinal()));
            }
            categoriasResponse.add(new CategoriaResponse(categoria.getId(), categoria.getNome(), faixasResponse));
        }

        return new TabelaTarifariaResponse(
                tabela.getId(),
                tabela.getNome(),
                tabela.getDataVigenciaInicio(),
                tabela.getDataVigenciaFim(),
                categoriasResponse
        );
    }

    private TabelaTarifariaResponse toTabelaTarifariaResponse(TabelaTarifaria tabela) {
        List<CategoriaResponse> categoriasResponse = tabela.getCategorias().stream()
                .map(this::toCategoriaResponse)
                .toList();

        return new TabelaTarifariaResponse(
                tabela.getId(),
                tabela.getNome(),
                tabela.getDataVigenciaInicio(),
                tabela.getDataVigenciaFim(),
                categoriasResponse
        );
    }

    private CategoriaResponse toCategoriaResponse(Categoria categoria) {
        List<FaixaConsumoResponse> faixasResponse = categoria.getFaixas().stream()
                .map(faixa -> new FaixaConsumoResponse(faixa.getFaixaInicial(), faixa.getFaixaFinal()))
                .toList();

        return new CategoriaResponse(categoria.getId(), categoria.getNome(), faixasResponse);
    }
}
