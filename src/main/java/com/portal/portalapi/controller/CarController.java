package com.portal.portalapi.controller;

import com.portal.portalapi.db.Car;
import com.portal.portalapi.message.KafkaProducerMessage;
import com.portal.portalapi.service.CarService.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    private CarService carService;


    @Autowired
    private KafkaProducerMessage kafkaMessage;

    @GetMapping("/kafkapost")
    public ResponseEntity postCarForSale(@RequestBody Car car){
        kafkaMessage.sendMessage(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Car>> getCarSales(){
        return ResponseEntity.status(HttpStatus.FOUND).body(carService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody Car car, @PathVariable("id") Long id){
        carService.changeCarForSale(car,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") Long id){
        carService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


