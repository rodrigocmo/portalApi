package com.portal.portalapi.service.CarService;

import com.portal.portalapi.client.CarClient;
import com.portal.portalapi.db.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService{

    @Autowired
    private CarClient carClient;


    @Override
    public List<Car> getCarForSales() {
        return null;
    }

    @Override
    public void changeCarForSale(Car car, Long id) {

    }

    @Override
    public void removeCarForSale(Long id) {

    }
}
