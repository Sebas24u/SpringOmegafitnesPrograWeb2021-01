package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Entrenador;
import pe.edu.upc.repository.IEntrenadorRepository;
import pe.edu.upc.service.IEntrenadorService;

@Service
public class EntrenadorServiceImpl implements IEntrenadorService {

	@Autowired
	private IEntrenadorRepository dEntrenador;
	
	@Override
	@Transactional
	public boolean insertar(Entrenador entrenador) {
		Entrenador objEntrenador = dEntrenador.save(entrenador);
		if(objEntrenador == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Entrenador entrenador) {
		boolean flag = false;
		try {
			dEntrenador.save(entrenador);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idEntrenador) {
		dEntrenador.deleteById(idEntrenador);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Entrenador> listarId(int idEntrenador) {
		return dEntrenador.findById(idEntrenador);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Entrenador> listar() {
		return dEntrenador.findAll();
	}

	@Override
	@Transactional
	public List<Entrenador> buscarNombre(String nombreEntrenador) {
		return dEntrenador.buscarNombre(nombreEntrenador);
	}

	@Override
	public Entrenador buscarporID(int IdEntrenador) {
		return 	dEntrenador.findById(IdEntrenador).orElse(null);
		
	}
	
}
