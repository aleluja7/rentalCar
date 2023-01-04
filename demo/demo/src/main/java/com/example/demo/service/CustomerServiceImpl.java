package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.entities.TipoDeVehiculo;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TipoDeVehiculoRepository;




@Service
public class CustomerServiceImpl {
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	TipoDeVehiculoRepository tipoRepository;
	
	
	
	public ResponseEntity<?> addExtraLoyaltyPoints(String documentId, String typeOfCar) {
		
		Optional<Customer> customer = Optional.of(customerRepository.findBydocumentId(documentId));
		Optional<TipoDeVehiculo> tipoDeVehiculo = Optional.of(tipoRepository.findByTipo(typeOfCar));
		if(!customer.isPresent()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
		if(!tipoDeVehiculo.isPresent()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Type of car not found");
		}
		
		Customer customer2 = customer.get();
		TipoDeVehiculo tipoDeVehiculo2 = tipoDeVehiculo.get();
		
		customer2.setLoyalty(customer2.getLoyalty() + tipoDeVehiculo2.getLoyaltyPoints()); 
		customerRepository.save(customer2);
		
		return ResponseEntity.ok(customer2);
		
	}
	
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	public Customer findByDocumentId(String documentId) {
		return customerRepository.findBydocumentId(documentId);
	}
	
	
}
