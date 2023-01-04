package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String modelo;
    private String matricula;
    private String potencia;
    @ManyToOne
    private TipoDeVehiculo tipodeVehiculo;
    private boolean isRented;
    @ManyToOne
    private Customer customer;
    
    
    //Constructors
    public Car() {
		
	}

	public Car(Long id, String modelo, String matricula, String potencia, TipoDeVehiculo tipodeVehiculo, Boolean isRented, Customer customer) {
		this.id = id;
		this.modelo = modelo;
		this.matricula = matricula;
		this.potencia = potencia;
		this.tipodeVehiculo = tipodeVehiculo;
		this.tipodeVehiculo = tipodeVehiculo;
		this.isRented = isRented;
		this.customer = customer;
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getPotencia() {
		return potencia;
	}



	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public TipoDeVehiculo getTipodeVehiculo() {
		return tipodeVehiculo;
	}

	public void setTipodeVehiculo(TipoDeVehiculo tipodeVehiculo) {
		this.tipodeVehiculo = tipodeVehiculo;
	}

	public boolean getIsRented() {
		return isRented;
	}

	public void setIsRented(boolean isRented) {
		this.isRented = isRented;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}


    
    
}
