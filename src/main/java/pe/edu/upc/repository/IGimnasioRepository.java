package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Gimnasio;

@Repository
public interface IGimnasioRepository extends JpaRepository<Gimnasio, Integer>{
	@Query("from Gimnasio g where g.nombreGimnasio like %:nombreGimnasio%")
	List<Gimnasio> buscarNombre(@Param("nombreGimnasio") String nombreGimnasio);
}
