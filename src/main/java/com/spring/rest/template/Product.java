package com.spring.rest.template;

import java.util.UUID;

public class Product {
	
	private String id;
	private String name;
	private String brand;
	private Double price;
	private String sku;
	
	
	//empty constructor
	public Product(String name,String brand,Double price,String sku) {
		super();
		id = UUID.randomUUID().toString();
		this.name=name;
		this.brand=brand;
		this.price=price;
		this.sku=sku;
	}
	
	// getters and setters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
	
	
	
}
