package com.kpo.kpo.Domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Meteostation implements Serializable {
    @ManyToOne()
    @JoinColumn(name = "place_id")
    private Place place;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private double coordination_x;

    private double coordination_y;

    public Long getId() {
        return id;
    }

    public Place getPlace() {
        return place;
    }

    public double getCoordination_x() {
        return coordination_x;
    }

    public void setCoordination_x(double coordination_x) {
        this.coordination_x = coordination_x;
    }

    public double getCoordination_y() {
        return coordination_y;
    }

    public void setCoordination_y(double coordination_y) {
        this.coordination_y = coordination_y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
