package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.TipoDocumento;

public interface ITipoDocumentoService {
	public boolean insertar(TipoDocumento td);
	public boolean modificar(TipoDocumento td);
	public void eliminar(int idTipoDocumento);
	public Optional<TipoDocumento> listarId(int idTipoDocumento);
	List<TipoDocumento> listar();

}
