package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Car;
import com.example.demo.entities.TipoDeVehiculo;



@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

  Car findByMatricula(String matricula);
  List<Car> findBytipodeVehiculo(TipoDeVehiculo tipodeVehiculo);
  
  Integer countBytipodeVehiculoAndIsRented(TipoDeVehiculo tipodeVehiculo, boolean isRented);
  

}
