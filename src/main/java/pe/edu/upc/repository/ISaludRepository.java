package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Salud;

@Repository
public interface ISaludRepository extends JpaRepository<Salud, Integer>{

	@Query("from Salud a where a.cliente.nombreCliente like %:nombreCliente%")
	List<Salud> findByNombreCliente(@Param("nombreCliente")String nombreCliente);
	@Query("select s from Salud s")
	List<Salud> listaDatos();
}
