package com.portal.portalapi.service.car;

import com.portal.portalapi.db.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    List<Car> getCarForSales();

    void changeCarForSale(Car car, Long id);

    void removeCarForSale(Long id);
}
