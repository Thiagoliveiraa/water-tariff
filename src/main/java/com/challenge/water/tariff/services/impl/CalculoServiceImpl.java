package com.challenge.water.tariff.services.impl;

import com.challenge.water.tariff.dtos.request.CalculoRequest;
import com.challenge.water.tariff.dtos.response.CalculoResponse;
import com.challenge.water.tariff.dtos.response.DetalheFaixaResponse;
import com.challenge.water.tariff.dtos.response.FaixaConsumoResponse;
import com.challenge.water.tariff.entities.Categoria;
import com.challenge.water.tariff.entities.FaixaConsumo;
import com.challenge.water.tariff.repositories.CategoriaTabelaRepository;
import com.challenge.water.tariff.services.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculoServiceImpl implements CalculoService {

    private final CategoriaTabelaRepository categoriaTabelaRepository;

    @Autowired
    public CalculoServiceImpl(CategoriaTabelaRepository categoriaTabelaRepository) {
        this.categoriaTabelaRepository = categoriaTabelaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public CalculoResponse calcular(CalculoRequest calculoRequest) {
        Categoria categoria = categoriaTabelaRepository.findByNome(
                        calculoRequest.categoria()
        ).orElseThrow(() -> new RuntimeException("Esta categoria não existe.")
        );

        BigDecimal valorTotal = BigDecimal.ZERO;
        int consumoResultante = calculoRequest.consumo();

        List<DetalheFaixaResponse> detalhamento = new ArrayList<>();

        for(FaixaConsumo faixa : categoria.getFaixas()) {
            if(consumoResultante <= 0) {
                break;
            }

            int capacacidadeFaixa = calcularCapacacidadeFaixa(faixa);
            int consumoM3CobradoFaixa =
                    Math.min(consumoResultante, capacacidadeFaixa);
            BigDecimal subTotal = faixa.getValorUnitario().multiply(
                    BigDecimal.valueOf(consumoM3CobradoFaixa)
            );

            consumoResultante -= consumoM3CobradoFaixa;

            detalhamento.add(
                    criarDetalheResponse(faixa, consumoM3CobradoFaixa, subTotal)
            );

            valorTotal = valorTotal.add(subTotal);
        }

        return new CalculoResponse(
                calculoRequest.categoria(), calculoRequest.consumo(),
        valorTotal.setScale(2, RoundingMode.HALF_EVEN), detalhamento);
    }

    private DetalheFaixaResponse criarDetalheResponse(
            FaixaConsumo faixa, int consumoM3CobradoFaixa, BigDecimal subTotal
    ) {
        return new DetalheFaixaResponse(
                new FaixaConsumoResponse(faixa.getFaixaInicial(), faixa.getFaixaFinal()),
                consumoM3CobradoFaixa, faixa.getValorUnitario().setScale(2, RoundingMode.HALF_EVEN),
                subTotal.setScale(2, RoundingMode.HALF_EVEN)
        );
    }

    private int calcularCapacacidadeFaixa(FaixaConsumo faixa) {
        if (faixa.getFaixaInicial() == 0) {
            return faixa.getFaixaFinal();
        }
        return faixa.getFaixaFinal() - faixa.getFaixaInicial() + 1;
    }
}
