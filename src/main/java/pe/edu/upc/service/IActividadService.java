package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Actividad;

public interface IActividadService {
	
	public boolean insertar(Actividad actividad);
	public boolean modificar(Actividad actividad);
	public void eliminar(int idActividad);
	public Optional<Actividad> listarId(int idActividad);
	List<Actividad> listar();
	List<Actividad> findByName(String nombreActividad);
	List<Actividad> findByNameSala(String nombreSala);

}
