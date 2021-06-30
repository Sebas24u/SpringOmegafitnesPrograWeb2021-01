package pe.edu.upc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Users;

@Repository
public interface IUsuarioRepository extends JpaRepository<Users, Long>{
	
	public Users findByUsername(String username);

}
