package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.TipoPlan;

public interface ITipoPlanService {
	public boolean insertar(TipoPlan tipoPlan);
	public boolean modificar(TipoPlan tipoPlan);
	public void eliminar(int idTipoPlan);
	public Optional<TipoPlan> listarId(int idTipoPlan);
	List<TipoPlan> listar();
	List<TipoPlan> buscarNombre(String nombreTipoPlan);

}
