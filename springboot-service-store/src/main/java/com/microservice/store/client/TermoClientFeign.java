package com.microservice.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.store.models.Termo;


@FeignClient(name = "service-termo")
public interface TermoClientFeign {

	@GetMapping("/list")
	public List<Termo> list();
	
	@GetMapping("/termo/{id}")
	public Termo detail(@PathVariable Long id);
}
