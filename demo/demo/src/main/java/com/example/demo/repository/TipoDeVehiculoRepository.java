package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TipoDeVehiculo;




@Repository
public interface TipoDeVehiculoRepository extends JpaRepository<TipoDeVehiculo, Long>{

	TipoDeVehiculo findByTipo(String tipo);
}
