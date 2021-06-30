package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Rutina;
import pe.edu.upc.repository.IRutinaRepository;
import pe.edu.upc.service.IRutinaService;

@Service
public class RutinaServiceImpl implements IRutinaService {

	@Autowired
	private IRutinaRepository rRutina;
	
	@Override
	@Transactional
	public boolean insertar(Rutina rutina) {
		Rutina objRutina = rRutina.save(rutina);
		if(objRutina == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Rutina rutina) {
		boolean flag = false;
		try {
			rRutina.save(rutina);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idRutina) {
		rRutina.deleteById(idRutina);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Rutina> listarId(int idRutina) {
		return rRutina.findById(idRutina);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Rutina> listar() {
		return rRutina.findAll();
	}

	@Override
	@Transactional
	public List<Rutina> buscarNombre(String nameRutina) {
		return rRutina.buscarNombre(nameRutina);
	}
	
}
