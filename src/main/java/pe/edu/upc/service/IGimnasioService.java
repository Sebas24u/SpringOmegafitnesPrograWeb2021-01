package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Gimnasio;

public interface IGimnasioService {
	public boolean insertar(Gimnasio gimnasio);
	public boolean modificar(Gimnasio gimnasio);
	public void eliminar(int idGimnasio);
	public Optional<Gimnasio> listarId(int idGimnasio);
	List<Gimnasio> listar();
	List<Gimnasio> buscarNombre(String nombreGimnasio);

}
