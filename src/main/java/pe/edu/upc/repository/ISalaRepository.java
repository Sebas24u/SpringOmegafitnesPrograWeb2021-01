package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Sala;

@Repository
public interface ISalaRepository  extends JpaRepository<Sala, Integer>{
	
	/*@Query("select s from Sala s where s.nombreSala like %:nombreSala%")
	List<Sala> findByName(String nombreSala);
	
	@Query("select s from Sala a where s.gimnasio.nombreGimnasio like %:nombreGimnasio%")
	List<Sala> findByNameGym(String nombreGimnasio);*/
	
}
