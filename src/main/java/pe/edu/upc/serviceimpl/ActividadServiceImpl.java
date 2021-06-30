package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Actividad;
import pe.edu.upc.repository.IActividadRepository;
import pe.edu.upc.service.IActividadService;

@Service
public class ActividadServiceImpl implements IActividadService {

	@Autowired
	private IActividadRepository actividadR;
	
	@Override
	@Transactional
	public boolean insertar(Actividad actividad) {
		Actividad objActividad = actividadR.save(actividad);
		if(objActividad == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Actividad actividad) {
		boolean flag = false;
		try {
			actividadR.save(actividad);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idActividad) {
		actividadR.deleteById(idActividad);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Actividad> listarId(int idActividad) {
		return actividadR.findById(idActividad);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Actividad> listar() {
		return actividadR.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Actividad> findByName(String nombreActividad) {
		List<Actividad> lista = actividadR.findByName(nombreActividad);
		return lista;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Actividad> findByNameSala(String nombreSala) {
		List<Actividad> lista = actividadR.findByNameSala(nombreSala);
		return lista;
	}

}
