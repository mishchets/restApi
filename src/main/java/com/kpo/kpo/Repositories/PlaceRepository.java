package com.kpo.kpo.Repositories;

import com.kpo.kpo.Domains.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
