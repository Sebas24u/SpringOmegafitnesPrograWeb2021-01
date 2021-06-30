package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.ClientePlan;

public interface IClientePlanService {
	public boolean insertar(ClientePlan clientePlan);
	public boolean modificar(ClientePlan clientePlan);
	public void eliminar(int idClientePlan);
	public Optional<ClientePlan> listarId(int idClientePlan);

	List<ClientePlan> listar();
	List<ClientePlan> findByNombrePlan(String nombreCliente);

	

}
