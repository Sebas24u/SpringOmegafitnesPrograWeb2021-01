package pe.edu.upc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Actividad;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer>{
	
	@Query("select a from Actividad a where a.nombreActividad like %:nombreActividad%")
	List<Actividad> findByName(String nombreActividad);
	
	@Query("select a from Actividad a where a.sala.nombreSala like %:nombreSala%")
	List<Actividad> findByNameSala(String nombreSala);
	
}
