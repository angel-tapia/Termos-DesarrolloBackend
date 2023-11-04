package com.microservice.store.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.store.models.Store;
import com.microservice.store.models.Termo;

@Service("serviceRest")
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private RestTemplate clientRest;

	@Override
	public List<Store> findAll() {
		List<Termo> termos = Arrays.asList(clientRest.getForObject("http://localhost:8000/list", Termo[].class));

		return termos.stream().map (p -> new Store (p, 1)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap <>();
		pathVariables.put("id", id.toString());
		Termo termo = clientRest.getForObject("http://localhost:8000/termo/{id}", Termo.class, pathVariables);
		return new Store(termo, cantidad);
	}
}
