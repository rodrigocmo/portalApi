package com.portal.portalapi.service.car;

import com.portal.portalapi.client.CarClient;
import com.portal.portalapi.db.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarClient carClient;


    @Override
    public List<Car> getCarForSales() {
        return carClient.carForSalesClient();
    }

    @Override
    public void changeCarForSale(Car car, Long id) {
        carClient.changeCarForSalesClient(car,id);
    }

    @Override
    public void removeCarForSale(Long id) {
        carClient.deleteCarForSalesClient(id);
    }
}
