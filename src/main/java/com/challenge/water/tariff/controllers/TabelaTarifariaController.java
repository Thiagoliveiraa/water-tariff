package com.challenge.water.tariff.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TabelaTarifariaController {
    //TODO: POST
    // POST /api/tabelas-tarifarias
    /*
    * Entrada(Payload): JSON contendo a estrutura completa da tabela
    *  (categorias + faixas + valores tarifarios).
    * */
    // GET /api/tabelas-tarifarias
    //TODO: GET Listar Tabelas Tarifárias
    /*
    * Retorna todas as tabelas tarifárias cadastradas no sistema.
    * Saída: Lista de tabelas com suas respectivas configurações.
    * */
    //TODO: DELETE Excluir Tabela Tarifária
    //DELETE /api/tabelas-tarifarias/{id}
    /*
    * Importante: Deve impedir que tabelas excluídas sejam utilizadas
    *  em cálculos futuros.
    *  Ou seja, levar em conta a integridade referencial
    *  de nao haver calculo sem tabela.
    * */

}
