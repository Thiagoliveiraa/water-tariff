package com.challenge.water.tariff.repositories;

import com.challenge.water.tariff.entities.TabelaTarifaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaTarifariaRepository extends JpaRepository<TabelaTarifaria, Long> {
}
