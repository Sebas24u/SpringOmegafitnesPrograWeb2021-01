package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Administrador;
import pe.edu.upc.model.Cliente;
import pe.edu.upc.repository.IAdministradorRepository;
import pe.edu.upc.service.IAdministradorService;

@Service
public class AdministradorServiceImpl implements IAdministradorService{

	@Autowired
	private IAdministradorRepository adminR;
	
	@Override
	@Transactional
	public boolean insertar(Administrador administrador) {
		Administrador objAdministrador = adminR.save(administrador);
		if(objAdministrador == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Administrador administrador) {
		boolean flag = false;
		try {
			adminR.save(administrador);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idAdministrador) {
		adminR.deleteById(idAdministrador);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Administrador> listarId(int idAdministrador) {
		return adminR.findById(idAdministrador);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Administrador> listar() {
		return adminR.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Administrador> findByName(String nombreAdministrador) {
		List<Administrador> lista = adminR.findByName(nombreAdministrador);
		return lista;
	}

/*	@Override
	@Transactional(readOnly=true)
	public List<Administrador> findByDocument(String documentoAdministrador) {
		List<Administrador> lista = adminR.findByDocument(documentoAdministrador);
		return lista;
	}*/

}
