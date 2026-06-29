package com.challenge.water.tariff.repositories;

import com.challenge.water.tariff.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoriaTabelaRepository extends JpaRepository<Categoria, Long> {
    @Query(
        """
            select distinct categoria 
            from Categoria categoria
            join fetch categoria.faixas faixas
            where categoria.nome = :nome
            order by faixas.faixaInicial
        """
    )
    Optional<Categoria> findByNome(@Param("nome") String nome);
}
