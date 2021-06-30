package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Alimentacion;
import pe.edu.upc.repository.IAlimentacionRepository;
import pe.edu.upc.service.IAlimentacionService;

@Service
public class AlimentacionServiceImpl implements IAlimentacionService {

	@Autowired
	private IAlimentacionRepository dAlimentacion;
	
	@Override
	@Transactional
	public boolean insertar(Alimentacion alimentacion) {
		Alimentacion objAlimentacion = dAlimentacion.save(alimentacion);
		if(objAlimentacion == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Alimentacion alimentacion) {
		boolean flag = false;
		try {
			dAlimentacion.save(alimentacion);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idAlimentacion) {
		dAlimentacion.deleteById(idAlimentacion);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alimentacion> listarId(int idAlimentacion) {
		return dAlimentacion.findById(idAlimentacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alimentacion> listar() {
		return dAlimentacion.findAll();
	}

	@Override
	@Transactional
	public List<Alimentacion> buscarNombre(String nombreAlimentacion) {
		return dAlimentacion.buscarNombre(nombreAlimentacion);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alimentacion> buscarId(int idAlimentacion) {
		// TODO Auto-generated method stub
		return dAlimentacion.findById(idAlimentacion);
	}

	
}
