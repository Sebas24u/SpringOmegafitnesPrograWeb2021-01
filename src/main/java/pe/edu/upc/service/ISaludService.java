package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;



import pe.edu.upc.model.Salud;

public interface ISaludService {

	public boolean insertar(Salud salud);
	public boolean modificar(Salud salud);
	public void eliminar(int idSalud);
	public Optional<Salud> listarId(int idSalud);
	List<Salud> listar();
	List<Salud> findByNombreCliente(String nombreCliente);
}
