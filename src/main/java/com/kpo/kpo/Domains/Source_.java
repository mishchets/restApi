package com.kpo.kpo.Domains;


import javax.persistence.*;

@Entity
@Table(name = "source_")
public class Source_ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
