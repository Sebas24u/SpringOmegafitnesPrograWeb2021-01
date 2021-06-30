package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.model.Entrenador;

@Repository
public interface IEntrenadorRepository extends JpaRepository<Entrenador, Integer>{
	@Query("from Entrenador e where e.nombreEntrenador like %:nombreEntrenador%")
	List<Entrenador> buscarNombre(@Param("nombreEntrenador") String nombreEntrenador);
}
