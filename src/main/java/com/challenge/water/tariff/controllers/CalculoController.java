package com.challenge.water.tariff.controllers;

import com.challenge.water.tariff.services.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //TODO: CREATE POST

    /*se precisar use o StringUtils do spring (StringUtils
    .hasText(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
    * Endpoint de Cálculo
        POST /api/calculos
        Entrada(Payload) (Request Body):
        json
        {
            "categoria": "INDUSTRIAL",
            "consumo": 18
        }
        *
        * Formato de Retorno Obrigatório
 O retorno deve ser detalhado e incluir:
 json
	 {
	 	"categoria": "INDUSTRIAL",
	 	"consumoTotal": 18,
	 	"valorTotal": 26.00,
	 	"detalhamento": [
		 		{
			 		"faixa": {
			 			"inicio": 0,
			 			"fim": 10
			 			},
			 			"m3Cobrados": 10,
			 			"valorUnitario": 1.00,
			 			"subtotal"; 10.00
		 		},
		 		{
		 			"faixa": {
			 			"inicio": 11,
			 			"fim": 20
			 			},
			 			"m3Cobrados": 8,
			 			"valorUnitario": 2.00,
			 			"subtotal"; 16.00
		 		}

		 	},
	 	]
	 }
        *
        *- categoria: String com a categoria utilizada
        - consumoTotal: Integer com o consumo informado
        - valorTotal: BigDecimal com o valor total a pagar
        - detalhamento: Array com breakdown por faixa
            - faixa.inicio: Integer
            - faixa.fim: Integer
            - m3Cobrados: Integer (quantidade de m3 cobrados naquela faixa)
            - valorUnitario: BigDecimal
            - subtotal: BigDecimal
        *
    * */
}
