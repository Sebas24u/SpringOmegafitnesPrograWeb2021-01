package pe.edu.upc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.model.Alimentacion;

@Repository
public interface IAlimentacionRepository extends JpaRepository<Alimentacion, Integer>{
	@Query("from Alimentacion a where a.nombreAlimentacion like %:nombreAlimentacion%")
	List<Alimentacion> buscarNombre(@Param("nombreAlimentacion") String nombreAlimentacion);
	

	
}
