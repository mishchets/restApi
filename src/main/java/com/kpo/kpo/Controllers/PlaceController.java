package com.kpo.kpo.Controllers;

import com.kpo.kpo.Domains.Place;
import com.kpo.kpo.Repositories.PlaceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("place")
@CrossOrigin(origins = "http://localhost:9000")
public class PlaceController {
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping
    public List<Place> list() {
        return placeRepository.findAll();
    }

    @GetMapping("{id}")
    public Place getOne(@PathVariable("id") Place place) {
        return place;
    }

    @PostMapping
    public Place create(@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @PutMapping("{id}")
    public Place update(@PathVariable("id") Place placeFromDB, @RequestBody Place place) {
        BeanUtils.copyProperties(place, placeFromDB, "id");
        return placeRepository.save(placeFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Place place) {
        placeRepository.delete(place);
    }
}
