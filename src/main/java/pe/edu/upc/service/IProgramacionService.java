package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Programacion;

public interface IProgramacionService {
	public boolean insertar(Programacion programacion);
	public boolean modificar(Programacion programacion);
	public void eliminar(int idProgramacion);
	public Optional<Programacion> listarId(int idProgramacion);
	public Optional<Programacion> buscarId(int idProgramacion);
	List<Programacion> listar();
	List<Programacion> buscarActividad(String nombreTipoPlan);
	

}
