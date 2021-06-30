package pe.edu.upc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Integer>{
	@Query("from Plan p where p.nombrePlan like %:nombrePlan%")
	List<Plan> buscarNombre(@Param("nombrePlan") String nombrePlan);
	
	@Query("from Plan p where p.tipoplan.nombreTipoPlan like %:nombreTipoPlan%")
	List<Plan> buscarTipoPlan(@Param("nombreTipoPlan") String nombreTipoPlan);
	
	@Query("from Plan p where p.nombrePlan like %:nombrePlan%")
	List<Plan> findByNombrePlan(String nombrePlan);
	
}
