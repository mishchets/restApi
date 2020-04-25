package com.kpo.kpo.Repositories;

import com.kpo.kpo.Domains.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    Forecast getForecastById(Long id);
}
