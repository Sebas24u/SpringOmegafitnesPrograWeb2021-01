package pe.edu.upc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import pe.edu.upc.model.RutinaCliente;


@Repository
public interface IRutinaClienteRepository extends JpaRepository<RutinaCliente, Integer>{
	
	/*@Query("from RutinaCliente p where p.cliente.nombreCliente like %:nombreCliente%")
	List<RutinaCliente> findByNombreCliente(String nombreCliente);*/
	
}
