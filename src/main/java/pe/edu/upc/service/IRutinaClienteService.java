package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.RutinaCliente;

public interface IRutinaClienteService {
	public boolean insertar(RutinaCliente rutinaCliente);
	public boolean modificar(RutinaCliente rutinaCliente);
	public void eliminar(int idRutinaCliente);
	public Optional<RutinaCliente> listarId(int idRutinaCliente);

	List<RutinaCliente> listar();
/*	List<RutinaCliente> findByNombrePlan(String nombreCliente);*/

	

}
