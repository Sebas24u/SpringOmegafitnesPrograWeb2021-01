package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.TipoPlan;

@Repository
public interface ITipoPlanRepository extends JpaRepository<TipoPlan, Integer>{
	@Query("from TipoPlan p where p.nombreTipoPlan like %:nombreTipoPlan%")
	List<TipoPlan> buscarNombre(@Param("nombreTipoPlan") String nombreTipoPlan);
}
