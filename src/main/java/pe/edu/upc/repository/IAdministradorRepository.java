package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Administrador;

@Repository
public interface IAdministradorRepository  extends JpaRepository<Administrador, Integer>{

	/*@Query("select count(a.documentoAdministrador) from Administrador a where a.documentoAdministrador = :documentoAdministrador")
	public int buscarDocumentoAdministrador(@Param("documentoAdministrador") String documentoAdministrador);
	*/
	@Query("from Administrador a where a.nombreAdministrador like %:nombreAdministrador%")
	List<Administrador> findByName(@Param("nombreAdministrador") String nombreAdministrador);
	
	/*@Query("select a from Administrador a where a.documentoAdministrador like %:documentoAdministrador%")
	List<Administrador> findByDocument(String documentoAdministrador);
	*/
}
