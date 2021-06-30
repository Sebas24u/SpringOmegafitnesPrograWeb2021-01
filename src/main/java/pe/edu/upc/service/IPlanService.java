package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Plan;

public interface IPlanService {
	public boolean insertar(Plan plan);
	public boolean modificar(Plan plan);
	public void eliminar(int idPlan);
	public Optional<Plan> listarId(int idPlan);
	public Optional<Plan> buscarId(int idPlan);
	List<Plan> listar();
	List<Plan> findByNombrePlan(String nombrePlan);
	List<Plan> buscarTipoPlan(String nombreTipoPlan);
	

}
