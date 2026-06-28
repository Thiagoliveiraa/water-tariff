package com.challenge.water.tariff.repositories;

import com.challenge.water.tariff.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaTabelaRepository extends JpaRepository<Categoria, Long> {
}
