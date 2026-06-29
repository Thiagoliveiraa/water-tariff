package com.challenge.water.tariff.services;

import com.challenge.water.tariff.dtos.request.CalculoRequest;
import com.challenge.water.tariff.dtos.response.CalculoResponse;
import jakarta.validation.Valid;

public interface CalculoService {
    CalculoResponse calcular(CalculoRequest calculoRequest);
}
