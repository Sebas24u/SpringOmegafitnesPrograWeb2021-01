package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.ActividadCliente;

@Repository
public interface IActividadClienteRepository extends JpaRepository<ActividadCliente, Integer>{
	/*@Query("select a from ActividadCliente a where a.nombreActividadCliente like %:nombreActividadCliente%")
	List<ActividadCliente> findByName(String nombreActividadCliente);
	
	@Query("select a from Actividad a where a.cliente.nombreCliente like %:nombreCliente%")
	List<ActividadCliente> findByNameCliente(String nombreCliente);
	
	@Query("select a from ActividadCliente a where a.actividad.nombreActividad like %:nombreActividad%")
	List<ActividadCliente> findByNameActividad(String nombreActividad);*/
}
