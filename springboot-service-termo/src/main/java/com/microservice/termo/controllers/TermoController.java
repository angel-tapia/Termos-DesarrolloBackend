package com.microservice.termo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.termo.entity.Termo;
import com.microservice.termo.service.TermoService;




@RestController
public class TermoController {

	@Autowired
	private TermoService service;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/list")
	public List<Termo> list(){
		return service.findAll().stream().map(termo ->{
					termo.setPort(port);
					return termo;
					}).collect(Collectors.toList());
	};
	
	@GetMapping("/termo/{id}")
	public Termo detail(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/termo/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/termo")
	public ResponseEntity<Termo> putTermo(@RequestBody Termo termo) {
		service.putTermo(termo.getId(), termo.getName(), termo.getMarca());
		return new ResponseEntity<>(termo, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/termo")
	public ResponseEntity<Termo> postTermo(@RequestBody Termo termo) {
		if (service.existsById(termo.getId())) {
			service.postTermo(termo.getName(), termo.getMarca());
			return new ResponseEntity<>(termo, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(termo, HttpStatus.NOT_FOUND);
		}
	}
}
