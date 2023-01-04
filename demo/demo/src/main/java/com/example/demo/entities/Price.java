package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Price {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double originalPrice;
	private Double priceExtraDay;
	private Double priceBeetween7and30days;
	private Double priceMore30days;
	
	
	
	public Price() {

	}
	
	public Price(Long id, Double originalPrice, Double priceExtraDay,
			Double priceBeetween7and30days, Double priceMore30days) {
		this.id = id;
		this.originalPrice = originalPrice;
		this.priceExtraDay = priceExtraDay;
		this.priceBeetween7and30days = priceBeetween7and30days;
		this.priceMore30days = priceMore30days;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}



	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}






	public Double getPriceBeetween7and30days() {
		return priceBeetween7and30days;
	}



	public void setPriceBeetween7and30days(Double priceBeetween7and30days) {
		this.priceBeetween7and30days = priceBeetween7and30days;
	}



	public Double getPriceMore30days() {
		return priceMore30days;
	}



	public void setPriceMore30days(Double priceMore30days) {
		this.priceMore30days = priceMore30days;
	}

	public Double getPriceExtraDay() {
		return priceExtraDay;
	}

	public void setPriceExtraDay(Double priceExtraDay) {
		this.priceExtraDay = priceExtraDay;
	}
	
	
	

}
