package com.portal.portalapi.client;

import com.portal.portalapi.db.Car;
import com.portal.portalapi.db.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarClient {

    @Autowired
    RestTemplate rest;

    private final String USER_CLIENT_URI = "http://localhost:8080/user";

    private final String SALES_CLIENT_URI = "http://localhost:8080/sales";


    public List<Car> carForSalesClient() {
        ResponseEntity<Car[]> responseEntity =  rest.getForEntity(SALES_CLIENT_URI+"/cars",Car[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }


   public void ownerPostClient(Owner newOwner){
        rest.postForEntity(USER_CLIENT_URI, newOwner,Owner.class);
   }


    public void changeCarForSalesClient(Car car, Long id){
    rest.put(SALES_CLIENT_URI+"/car/"+id,car,Car.class);
    }

    public void deleteCarForSalesClient(Long id){
        rest.delete(SALES_CLIENT_URI+"/car"+id);
    }



}
