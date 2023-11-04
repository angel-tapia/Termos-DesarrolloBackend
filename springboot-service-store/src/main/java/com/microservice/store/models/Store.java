package com.microservice.store.models;

public class Store {
	private Termo termo;
	private Integer cantidad;
	
	public Store() {
		
	}
	
	public Store(Termo termo, Integer cantidad) {
		this.termo = termo;
		this.cantidad = cantidad;
	}

	public Termo getTermo() {
		return termo;
	}

	public void setTermo(Termo termo) {
		this.termo = termo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
//	public double getTotal() {
//		return product.getPrice() * cantidad.doubleValue();
//	}
	
}
