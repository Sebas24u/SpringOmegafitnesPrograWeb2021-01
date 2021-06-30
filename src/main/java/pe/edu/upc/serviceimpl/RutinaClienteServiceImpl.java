package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.model.RutinaCliente;
import pe.edu.upc.repository.IRutinaClienteRepository;
import pe.edu.upc.service.IRutinaClienteService;

@Service
public class RutinaClienteServiceImpl implements IRutinaClienteService {

	@Autowired
	private IRutinaClienteRepository dRutinaCliente;
	
	@Override
	@Transactional
	public boolean insertar(RutinaCliente rutinaCliente) {
		RutinaCliente objRutinaCliente = dRutinaCliente.save(rutinaCliente);
		if(objRutinaCliente == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(RutinaCliente rutinaCliente) {
		boolean flag = false;
		try {
			dRutinaCliente.save(rutinaCliente);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idRutinaCliente) {
		dRutinaCliente.deleteById(idRutinaCliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<RutinaCliente> listarId(int idRutinaCliente) {
		return dRutinaCliente.findById(idRutinaCliente);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RutinaCliente> listar() {
		return dRutinaCliente.findAll();
	}

	/*@Override
	public List<RutinaCliente> findByNombrePlan(String nombreCliente) {
		// TODO Auto-generated method stub
		return null;
	}

*/



	

	
}
