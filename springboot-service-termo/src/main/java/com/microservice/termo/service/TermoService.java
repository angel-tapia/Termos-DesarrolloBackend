package com.microservice.termo.service;

import java.util.List;

import com.microservice.termo.entity.*;

public interface TermoService {
	
	/**
	 * This method returns all the list of Termos.
	 * @return
	 */
	public List<Termo> findAll();
	
	/**
	 * This method returns the Termo associated with an Id
	 * @param id
	 * @return void
	 */
	public Termo findById(Long id);
	
	/**
	 * This method deletes the Termo associated with an Id
	 * @param id: represents the id of the Termo.
	 * @return void
	 */
	public void deleteById(Long id);
	
	/**
	 * This method modifies a termo associated with an Id.
	 * @param id: represents the id of the termo
	 * @param name: represents the name of the termo
	 * @param marca: represents the brand of the termo
	 */
	public void putTermo(Long id, String name, String marca);
	
	/**
	 * This method creates a termo.
	 * @param name: represents the name of the termo
	 * @param marca: represents the brand of the termo
	 */
	public void postTermo(String name, String marca);

	boolean existsById(Long id);

}
