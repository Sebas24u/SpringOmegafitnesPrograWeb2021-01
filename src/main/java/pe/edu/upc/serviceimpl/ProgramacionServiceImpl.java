package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.model.Programacion;
import pe.edu.upc.repository.IProgramacionRepository;
import pe.edu.upc.service.IProgramacionService;

@Service
public class ProgramacionServiceImpl implements IProgramacionService {

	@Autowired
	private IProgramacionRepository dProgramacion;
	
	@Override
	@Transactional
	public boolean insertar(Programacion programacion) {
		Programacion objProgramacion = dProgramacion.save(programacion);
		if(objProgramacion == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Programacion programacion) {
		boolean flag = false;
		try {
			dProgramacion.save(programacion);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idProgramacion) {
		dProgramacion.deleteById(idProgramacion);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Programacion> listarId(int idProgramacion) {
		return dProgramacion.findById(idProgramacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Programacion> listar() {
		return dProgramacion.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Programacion> buscarId(int idProgramacion) {
		// TODO Auto-generated method stub
		return dProgramacion.findById(idProgramacion);
	}

	@Override
	public List<Programacion> buscarActividad(String nombreActividad) {
		// TODO Auto-generated method stub
		return dProgramacion.buscarActividad(nombreActividad);
	}
	
}
