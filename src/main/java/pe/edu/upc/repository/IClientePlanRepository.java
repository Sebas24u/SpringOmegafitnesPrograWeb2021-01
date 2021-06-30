package pe.edu.upc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;


import pe.edu.upc.model.ClientePlan;


@Repository
public interface IClientePlanRepository extends JpaRepository<ClientePlan, Integer>{
	
	@Query("from ClientePlan p where p.cliente.nombreCliente like %:nombreCliente%")
	List<ClientePlan> findByNombreCliente(String nombreCliente);
	
}
