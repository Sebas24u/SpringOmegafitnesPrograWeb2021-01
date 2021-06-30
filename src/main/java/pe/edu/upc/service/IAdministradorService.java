package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Administrador;

public interface IAdministradorService {
	public boolean insertar(Administrador administrador);
	public boolean modificar(Administrador administrador);
	public void eliminar(int idAdministrador);
	public Optional<Administrador> listarId(int idAdministrador);
	List<Administrador> listar();
	List<Administrador> findByName(String nombreAdministrador);
	/*List<Administrador> findByDocument(String documentoAdministrador);*/
	
}
