package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Car;
import com.example.demo.model.Inventory;
import com.example.demo.service.CarServiceImpl;



@RestController
public class CarController {
	
	private final Logger log = LoggerFactory.getLogger(CarController.class);

	@Autowired
    CarServiceImpl carServiceImpl;
      
    

    /**
     * Devuelve una lista del inventario de coches
     * http://localhost:8081/api/cars
     * @return
     */
    @GetMapping("/api/cars")
    public List<Car> findAll(){
        return carServiceImpl.findAll();
    }
	
    
    /**
     * Devuelve una lista del inventario de coches
     * http://localhost:8081/api/car/${matricula}
     * @return
     */
    @GetMapping("/api/car/{matricula}")
    public Car findByMatricula(@PathVariable String matricula){
        return carServiceImpl.findByMatricula(matricula);
    }
    
    /**
     * Devuelve una lista del inventario de coches de un tipo especifico SUV/PREMIUM/SMALL
     * http://localhost:8081/api/cars/type/{tipo}
     * @return
     */
    @GetMapping("/api/cars/type/{tipo}")
    public List<Car> findByType(@PathVariable String tipo){
    	return carServiceImpl.findByType(tipo.toLowerCase());
    }
    
    /**
     * Devuelve una lista del inventario de coches si estan alguilados o no estan alquilados dependiendo del valor 
     * http://localhost:8081//api/cars/type/inventory/rented/{isRented}
     * @return
     */
    @GetMapping("/api/cars/type/inventory/rented/{isRented}")
    public Inventory inventoryIsRented(@PathVariable boolean isRented){
    	return carServiceImpl.inventory(isRented);
    }
    
    /**
     * Devuelve el calculo 
     * http://localhost:8081/api/car/{matricula}/{days}
     * @return
     */
    @GetMapping("/api/car/{type}/{days}")
    public ResponseEntity<?> calculatePriceByTipoAndDays(@PathVariable String type,@PathVariable int days){
    	return carServiceImpl.calculatePriceByTipoAndDays(type.toLowerCase(), days);
    
    }
    
    /**
     * Devuelve una lista del inventario de coches de un tipo especifico SUV/PREMIUM/SMALL
     * http://localhost:8081/api/car/{tipo}/extra/{days}
     * @return
     */
    @GetMapping("/api/car/{type}/extra/{days}")
    public ResponseEntity<?> calculatePriceExtraDays(@PathVariable String type,@PathVariable int days){
    	return carServiceImpl.calculatePriceExtraDays(type.toLowerCase(), days);
    }
    
    
	

}
