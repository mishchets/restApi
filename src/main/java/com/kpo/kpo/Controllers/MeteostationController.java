package com.kpo.kpo.Controllers;

import com.kpo.kpo.Domains.Forecast;
import com.kpo.kpo.Domains.Meteostation;
import com.kpo.kpo.Repositories.MeteostationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meteostation")
@CrossOrigin
public class MeteostationController {
    private final MeteostationRepository meteostationRepository;

    @Autowired
    public MeteostationController(MeteostationRepository meteostationRepository) {
        this.meteostationRepository = meteostationRepository;
    }

    @GetMapping
    public List<Meteostation> listAll() {
        List <Meteostation> meteostations = meteostationRepository.findAll();
        return meteostations;
    }

    @GetMapping("{id}")
    public Meteostation listOne(@PathVariable Long id) {
        Meteostation meteostation = meteostationRepository.findById(id).get();
        return meteostation;
    }

    @PostMapping
    public Meteostation create(@RequestBody Meteostation meteostation) {
        Meteostation meteostationFromDB = meteostationRepository.getMeteostationById(meteostation.getId());
        if (meteostationFromDB != null) {
            return null;
        }
        return meteostationRepository.save(meteostation);
    }

    @PutMapping("{id}")
    public Meteostation update(@RequestBody Meteostation meteostation,
                               @PathVariable Long id
                               ) {
        Meteostation meteostationFromDB = meteostationRepository.getMeteostationById(id);
        if (meteostationFromDB != null) {
            return meteostationRepository.save(meteostation);
        }
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        meteostationRepository.deleteById(id);
    }
}
