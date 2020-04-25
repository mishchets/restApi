package com.kpo.kpo.Repositories;

import com.kpo.kpo.Domains.Meteostation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeteostationRepository extends JpaRepository<Meteostation, Long> {
    Meteostation getMeteostationById(long id);
}
