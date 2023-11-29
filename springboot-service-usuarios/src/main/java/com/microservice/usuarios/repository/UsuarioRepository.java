package com.microservice.usuarios.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;

import com.microservice.usuarios.entity.*;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
	
	
	// SELECT u from Usuario  u where u.username = ?1
	public Usuario findByUsername(String username); 
	
	// SELECT u from Usuario  u where u.username = ?1 and u.email = ?2
	public Usuario findByUsernameAndEmail(String username, String email);
	
	@Query(value = "SELECT u from Usuario  u where u.username = ?1")
	public Usuario obtenerPorUsername(String username);
	
	@Query(value = "SELECT u from Usuario  u where u.username = ?1 and u.email = ?2")
	public Usuario obtenerPorUsernameYEmail(String username, String email);
	
}
