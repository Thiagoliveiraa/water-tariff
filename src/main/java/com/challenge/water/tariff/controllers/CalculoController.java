package com.challenge.water.tariff.controllers;

import com.challenge.water.tariff.dtos.request.CalculoRequest;
import com.challenge.water.tariff.dtos.response.CalculoResponse;
import com.challenge.water.tariff.services.CalculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/calculos")
public class CalculoController {

    private final CalculoService calculoService;

    @Autowired
    public CalculoController(CalculoService calculoService) {
        this.calculoService = calculoService;
    }

    @PostMapping
    public ResponseEntity<CalculoResponse> calcular(@Valid @RequestBody CalculoRequest calculoRequest) {
        CalculoResponse calculoResponse =  calculoService.calcular(calculoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(calculoResponse);
    }
}
