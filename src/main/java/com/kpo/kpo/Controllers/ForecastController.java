package com.kpo.kpo.Controllers;

import com.kpo.kpo.Domains.Forecast;
import com.kpo.kpo.Repositories.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("forecast")
@CrossOrigin
public class ForecastController {
    private final ForecastRepository forecastRepository;

    @Autowired
    public ForecastController(ForecastRepository forecastRepository) {
        this.forecastRepository = forecastRepository;
    }

    @GetMapping
    public List<Forecast> listAll() {
        List<Forecast> forecasts = forecastRepository.findAll();
        return forecasts;
    }

    @GetMapping("{id}")
    public Forecast listOne(@PathVariable Long id) {
        Forecast forecast = forecastRepository.findById(id).get();
        return forecast;
    }

    @PostMapping
    public Forecast create(@RequestBody Forecast forecast) {
        Forecast forecastFromDB = forecastRepository.getForecastById(forecast.getId());
        if (forecastFromDB != null) {
            return null;
        }
        return forecastRepository.save(forecast);
    }

    @PutMapping("{id}")
    public Forecast update(@RequestBody Forecast forecast,
                           @PathVariable Long id) {
        Forecast forecastFromDB = forecastRepository.getForecastById(id);

        if (forecastFromDB != null) {
            return forecastRepository.save(forecast);
        }
        return null;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        forecastRepository.deleteById(id);
    }
}
