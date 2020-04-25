package com.kpo.kpo.Domains;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table
public class Forecast implements Serializable {
    @ManyToOne()
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne()
    @JoinColumn(name = "source_id")
    private Source_ source;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp dateTime;

    private Integer temperature;

    private String cloud;

    private String wind_dir;

    private Integer wind_speed;

    private Integer precipitation;

    public Long getId() {
        return id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Integer getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Integer wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Integer getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public Place getPlace() {
        return place;
    }

    public Source_ getSource() {
        return source;
    }
}
