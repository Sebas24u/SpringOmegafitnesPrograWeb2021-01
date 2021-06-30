package pe.edu.upc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.model.Programacion;

@Repository
public interface IProgramacionRepository extends JpaRepository<Programacion, Integer>{
	
	@Query("from Programacion p where p.actividad.nombreActividad like %:nombreActividad%")
	List<Programacion> buscarActividad(@Param("nombreActividad") String nombreActividad);
	
	
}
