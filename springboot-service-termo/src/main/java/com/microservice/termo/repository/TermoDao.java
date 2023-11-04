package com.microservice.termo.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.termo.entity.*;

public interface TermoDao extends CrudRepository<Termo, Long>{

}
