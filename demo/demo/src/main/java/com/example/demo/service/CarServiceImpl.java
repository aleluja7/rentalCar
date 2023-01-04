package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Car;
import com.example.demo.entities.TipoDeVehiculo;
import com.example.demo.model.Inventory;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.TipoDeVehiculoRepository;



@Service
public class CarServiceImpl {
	
	private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	TipoDeVehiculoRepository tipoRepository;
	
	@Autowired
	PriceRepository priceRepository;
	
	
	public List<Car> findAll(){
		return carRepository.findAll();
	}
	
    public Car findByMatricula(String matricula){
        return carRepository.findByMatricula(matricula);
    }
    
    public List<Car> findByType(String tipo){
    	TipoDeVehiculo type = tipoRepository.findByTipo(tipo);
        return carRepository.findBytipodeVehiculo(type);
    }
    
    
    public Inventory inventory(boolean isRented){
    	List<TipoDeVehiculo> listType = tipoRepository.findAll();
    	return checkInventory(listType,isRented);
    }
    
    private Inventory checkInventory(List<TipoDeVehiculo> listType, boolean isRented) {
    	Inventory inventory = new Inventory();
    	for (TipoDeVehiculo tipoDeVehiculo : listType) {
    		if(tipoDeVehiculo.getTipo().equals("suv")) {
    			inventory.setSuvCars(carRepository.countBytipodeVehiculoAndIsRented(tipoDeVehiculo, isRented));
    		}
    		else if(tipoDeVehiculo.getTipo().equals("premium")) {
    			inventory.setPremiumCars(carRepository.countBytipodeVehiculoAndIsRented(tipoDeVehiculo, isRented));
    		}
    		if(tipoDeVehiculo.getTipo().equals("small")) {
    			inventory.setSmallCars(carRepository.countBytipodeVehiculoAndIsRented(tipoDeVehiculo, isRented));
    		}
		}
    	return inventory;
    }
    
    public ResponseEntity<?>  calculatePriceByTipoAndDays(String tipo, int days) {
    	
    	if(days < 0) {
    		return ResponseEntity.badRequest().body("Error, no pueden ser dias negativos");    	
    	}
    	TipoDeVehiculo tipoDeVehiculo  = tipoRepository.findByTipo(tipo);
    	
    	if(tipoDeVehiculo == null) {
    		return ResponseEntity.badRequest().body("Error, este tipo de vehiculo no existe");    	
    	}
    	
    	Double finalPrice = 0.0;
    	Double price = 0.0;
    	log.warn("days -->" + days );
    	if(days <= 7) {
    		log.warn("primer if");
    		finalPrice = days * tipoDeVehiculo.getPrice().getOriginalPrice();
    	} else {
    		
    		int days7 = 7;
    		int days730 = 0;
    		int daysmas30 = 0;
    		
    		if(days > 30) {
    			days730 = 30 - days7;
    			daysmas30 = days - 30;
    		} else {
    			days730 = days - days7;
    		}
    		
    		log.warn("days7 -->" + days7);
    		log.warn("days730 -->" + days730);
    		log.warn("daysmas30 -->" + daysmas30);
    		
    		price = tipoDeVehiculo.getPrice().getOriginalPrice();
    		finalPrice = days7 * price;
    		
    		if(days730 > 0) {
    			log.warn("test --> " + tipoDeVehiculo.getPrice().getPriceBeetween7and30days());
    			if(tipoDeVehiculo.getPrice().getPriceBeetween7and30days() != null) {
    				price = tipoDeVehiculo.getPrice().getPriceBeetween7and30days();
    			}
    			finalPrice = finalPrice + (days730 * price);
    		}
    		
    		if(daysmas30 > 0) {
    			log.warn("test --> " + tipoDeVehiculo.getPrice().getPriceMore30days());
    			if(tipoDeVehiculo.getPrice().getPriceMore30days() != null) {
    				price = tipoDeVehiculo.getPrice().getPriceMore30days();
    			}
    			finalPrice = finalPrice + (daysmas30 * price);
    		}
    	}
    	
    	return ResponseEntity.ok(finalPrice);
    }
    
    
    public ResponseEntity<?> calculatePriceExtraDays(String tipo, int days) {
    	
    	if(days < 0) {
    		return ResponseEntity.badRequest().body("Error, no pueden ser dias negativos");    	
    	}
    	TipoDeVehiculo tipoDeVehiculo  = tipoRepository.findByTipo(tipo);
    	
    	if(tipoDeVehiculo == null) {
    		return ResponseEntity.badRequest().body("Error, este tipo de vehiculo no existe");    	
    	}
    	
    	Double finalPrice = 0.0;
    	log.warn("days -->" + days );
    	
    	finalPrice = days * tipoDeVehiculo.getPrice().getPriceExtraDay();
    
    	
    	return ResponseEntity.ok(finalPrice);
    }

}
