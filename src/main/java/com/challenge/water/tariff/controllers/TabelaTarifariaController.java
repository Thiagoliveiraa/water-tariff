package com.challenge.water.tariff.controllers;

import com.challenge.water.tariff.dtos.request.TabelaRequest;
import com.challenge.water.tariff.dtos.response.TabelaTarifariaResponse;
import com.challenge.water.tariff.services.TabelaTarifariaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tabelas-tarifarias")
public class TabelaTarifariaController {

    private final TabelaTarifariaService tabelaTarifariaService;

    @Autowired
    public TabelaTarifariaController(TabelaTarifariaService tabelaTarifariaService) {
        this.tabelaTarifariaService = tabelaTarifariaService;
    }

    @PostMapping
    public ResponseEntity<TabelaTarifariaResponse> criarTabelaTarifaria(
            @Valid @RequestBody TabelaRequest request
    ) {
        TabelaTarifariaResponse tabelaTarifariaResponse =  tabelaTarifariaService.criarTabelaTarifaria(
                request
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(tabelaTarifariaResponse);
    }

    @GetMapping
    public ResponseEntity<List<TabelaTarifariaResponse>> listarTabelasTarifarias() {
        List<TabelaTarifariaResponse> tabelasTarifariaResponse =
                tabelaTarifariaService.listarTabelasTarifarias();

        return ResponseEntity.ok().body(tabelasTarifariaResponse);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteTabelaTarifaria(@PathVariable Long id){
        tabelaTarifariaService.deleteTabelaTarifaria(id);
        return ResponseEntity.noContent().build();
    }
}
