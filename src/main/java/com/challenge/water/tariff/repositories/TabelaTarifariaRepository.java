package com.challenge.water.tariff.repositories;


import com.challenge.water.tariff.entities.Categoria;
import com.challenge.water.tariff.entities.TabelaTarifaria;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TabelaTarifariaRepository extends JpaRepository<TabelaTarifaria, Long> {
    @Query(
            """
                SELECT DISTINCT tabela FROM TabelaTarifaria tabela LEFT JOIN FETCH tabela.categorias
            """)
    List<TabelaTarifaria> findAllWithCategorias();

    @Query(
            """
                SELECT DISTINCT categoria FROM Categoria categoria LEFT JOIN FETCH categoria.faixas WHERE
                             categoria.tabelaTarifaria IN :tabelas
            """)
    List<Categoria> fetchFaixasParaCategorias(@Param("tabelas") List<TabelaTarifaria> tabelas);
}
