package com.complexica.travelforecast.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@Entity
@Table(name="weather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer temperature;

    private String description;

    private LocalDateTime weatherDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private CityEntity city;

    public WeatherEntity(Integer temperature, String description, LocalDateTime weatherDate, CityEntity city) {
        this.temperature = temperature;
        this.description = description;
        this.weatherDate = weatherDate;
        this.city = city;
    }
}
