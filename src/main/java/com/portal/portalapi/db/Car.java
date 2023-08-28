package com.portal.portalapi.db;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude
public class Car {

    private String idCar;
    private String model;
    private String brand;
    private String price;
    private String description;
    private String city;
    private Owner owner;
}
