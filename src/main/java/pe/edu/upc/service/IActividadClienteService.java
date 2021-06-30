package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.ActividadCliente;

public interface IActividadClienteService {

	public boolean insertar(ActividadCliente actividadCliente);
	public boolean modificar(ActividadCliente actividadCliente);
	public void eliminar(int idActividadCliente);
	public Optional<ActividadCliente> listarId(int idActividadCliente);
	List<ActividadCliente> listar();
/*	List<ActividadCliente> findByName(String nombreActividadCliente);
	List<ActividadCliente> findByNameCliente(String nombreCliente);
	List<ActividadCliente> findByNameActividad(String nombreActividad);*/
}
