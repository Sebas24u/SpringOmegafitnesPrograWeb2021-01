package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Gimnasio;
import pe.edu.upc.repository.IGimnasioRepository;
import pe.edu.upc.service.IGimnasioService;

@Service
public class GimnasioServiceImpl implements IGimnasioService {

	@Autowired
	private IGimnasioRepository dGimnasio;
	
	@Override
	@Transactional
	public boolean insertar(Gimnasio gimnasio) {
		Gimnasio objGimnasio = dGimnasio.save(gimnasio);
		if(objGimnasio == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Gimnasio gimnasio) {
		boolean flag = false;
		try {
			dGimnasio.save(gimnasio);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idGimnasio) {
		dGimnasio.deleteById(idGimnasio);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Gimnasio> listarId(int idGimnasio) {
		return dGimnasio.findById(idGimnasio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Gimnasio> listar() {
		return dGimnasio.findAll();
	}

	@Override
	@Transactional
	public List<Gimnasio> buscarNombre(String nameGimnasio) {
		return dGimnasio.buscarNombre(nameGimnasio);
	}
	
}
