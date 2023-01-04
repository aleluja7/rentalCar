package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Price;



@Repository
public interface  PriceRepository extends JpaRepository<Price, Long>{

}
