package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.service.CustomerServiceImpl;



@RestController
public class CustomerController {

	
	private final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
    CustomerServiceImpl customerServiceImpl;
	
    /**
     * Devuelve una lista de todos los clientes
     * http://localhost:8081/api/customers
     * @return
     */
	@GetMapping("/api/customers")
    public List<Customer> findAll(){
    	return customerServiceImpl.findAll();
    }
    
    /**
     * Devuelve un cliente a partir de un documento de Identificacion
     * http://localhost:8081/api/customer/{documentId}
     * @return
     */
	@GetMapping("/api/customer/{documentId}")
    public Customer findByDocumentId(@PathVariable String documentId){
    	return customerServiceImpl.findByDocumentId(documentId);
    }
    
    /**
     * Suma puntos loyalty a partir un documento de identificacion y un tipo de coche alquilado
     * http://localhost:8081/api/customer/{documentId}/rentcar/{typeOfCar}
     * @return
     */
    @PostMapping("/api/customer/{documentId}/rentcar/{typeOfCar}")
    public ResponseEntity<?> calculatePriceExtraDays(@PathVariable String documentId,@PathVariable String typeOfCar){
    	return customerServiceImpl.addExtraLoyaltyPoints(documentId, typeOfCar.toLowerCase());
    }
	
	
}
