package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Sala;
import pe.edu.upc.repository.ISalaRepository;
import pe.edu.upc.service.ISalaService;

@Service
public class SalaServiceImpl implements ISalaService{

	@Autowired
	private ISalaRepository salaR;
	
	@Override
	@Transactional
	public boolean insertar(Sala sala) {
		Sala objSala = salaR.save(sala);
		if(objSala == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Sala sala) {
		boolean flag = false;
		try {
			salaR.save(sala);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idSala) {
		salaR.deleteById(idSala);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Sala> listarId(int idSala) {
		return salaR.findById(idSala);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Sala> listar() {
		return salaR.findAll();
	}

/*	@Override
	@Transactional(readOnly=true)
	public List<Sala> findByName(String nombreSala) {
		List<Sala> lista = salaR.findByName(nombreSala);
		return lista;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Sala> findByNameGym(String nombreGimnasio) {
		List<Sala> lista = salaR.findByNameGym(nombreGimnasio);
		return lista;
	}
*/
}
