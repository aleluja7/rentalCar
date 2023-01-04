package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.ctes.Constants;
import com.example.demo.entities.Car;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Price;
import com.example.demo.entities.TipoDeVehiculo;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PriceRepository;
import com.example.demo.repository.TipoDeVehiculoRepository;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CarRepository repositoryCar = context.getBean(CarRepository.class);
		TipoDeVehiculoRepository repositoryTipodeVehiculo = context.getBean(TipoDeVehiculoRepository.class);
		PriceRepository repositoryPrice = context.getBean(PriceRepository.class);
		CustomerRepository customerRepository =  context.getBean(CustomerRepository.class);
		
		
		Customer customer1 = new Customer(null, "11111111A", "Alejandro", "aaaa", 18);
		Customer customer2 = new Customer(null, "11111111B", "Teresa", "bbbb", 2);
		Customer customer3 = new Customer(null, "11111111C", "Carlos", "cccc", 38);
		Customer customer4 = new Customer(null, "11111111D", "Javier", "dddd", 58);
		Customer customer5 = new Customer(null, "11111111E", "Jaime", "eeee", 12);
		Customer customer6 = new Customer(null, "11111111F", "Sergio", "fffff", 3);
		Customer customer7 = new Customer(null, "11111111G", "Junior", "eeeee", 200);

		Price priceSmall = new Price(null, Constants.pricePriceSmall, (Constants.pricePriceSmall + Constants.pricePriceSmall*0.3), (Constants.pricePriceSmall*0.6), null);
		Price pricePremium = new Price(null, Constants.pricePricePremium, (Constants.pricePricePremium + (Constants.pricePricePremium * 0.2)), null, null);
		Price priceSUV = new Price(null, Constants.pricePriceSUV, Constants.pricePriceSUV + (Constants.pricePriceSmall*0.6), (Constants.pricePriceSUV*0.8), (Constants.pricePriceSUV*0.5));
		
		TipoDeVehiculo tipodeVehiculoSUV = new TipoDeVehiculo(null, "suv", priceSUV, 3);
		TipoDeVehiculo tipodeVehiculoPremium = new TipoDeVehiculo(null, "premium", pricePremium, 5);
		TipoDeVehiculo tipodeVehiculoSmall = new TipoDeVehiculo(null, "small", priceSmall, 1);
		
		Car car1 = new Car(null, "Toyota", "1111BBB", "168", tipodeVehiculoSUV, false, null);
		Car car2 = new Car(null, "Mercedes", "1111CCC", "180", tipodeVehiculoSUV, true, null);
		Car car3 = new Car(null, "Toyota", "1111DDD", "160", tipodeVehiculoSUV, false, null);
		Car car4 = new Car(null, "Mercedes", "1111FFF", "180", tipodeVehiculoSUV, false, null);
		Car car5 = new Car(null, "Toyota", "1111GGG", "190", tipodeVehiculoSUV, true, null);
		Car car6 = new Car(null, "Mercedes", "1111HHH", "180", tipodeVehiculoSUV, true, null);

		Car car7 = new Car(null, "Seat", "2222BBB", "120", tipodeVehiculoSmall, true, null);
		Car car8 = new Car(null, "Nissan", "2222CCC", "120",tipodeVehiculoSmall, false, null);
		Car car9 = new Car(null, "Seat", "2222DDD", "120", tipodeVehiculoSmall, false, null);
		Car car10 = new Car(null, "Nissan", "2222FFF", "120",tipodeVehiculoSmall, false, null);


		Car car11 = new Car(null, "Ferrari", "3333BBB", "400", tipodeVehiculoPremium, true, null);
		Car car12 = new Car(null, "Porche", "3333CCC", "320", tipodeVehiculoPremium, false, null);
		
		repositoryPrice.save(priceSmall);
		repositoryPrice.save(pricePremium);
		repositoryPrice.save(priceSUV);
		
		repositoryTipodeVehiculo.save(tipodeVehiculoSmall);
		repositoryTipodeVehiculo.save(tipodeVehiculoSUV);
		repositoryTipodeVehiculo.save(tipodeVehiculoPremium);
		
		repositoryCar.save(car1);
		repositoryCar.save(car2);
		repositoryCar.save(car3);
		repositoryCar.save(car4);
		repositoryCar.save(car5);
		repositoryCar.save(car6);
		repositoryCar.save(car7);
		repositoryCar.save(car8);
		repositoryCar.save(car9);
		repositoryCar.save(car10);
		repositoryCar.save(car11);
		repositoryCar.save(car12);
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		customerRepository.save(customer4);
		customerRepository.save(customer5);
		customerRepository.save(customer6);
		customerRepository.save(customer7);
	}

}
