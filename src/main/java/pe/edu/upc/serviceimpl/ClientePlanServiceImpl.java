package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.model.ClientePlan;
import pe.edu.upc.repository.IClientePlanRepository;
import pe.edu.upc.service.IClientePlanService;

@Service
public class ClientePlanServiceImpl implements IClientePlanService {

	@Autowired
	private IClientePlanRepository dClientePlan;
	
	@Override
	@Transactional
	public boolean insertar(ClientePlan clienteplan) {
		ClientePlan objPlan = dClientePlan.save(clienteplan);
		if(objPlan == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(ClientePlan clienteplan) {
		boolean flag = false;
		try {
			dClientePlan.save(clienteplan);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPlan) {
		dClientePlan.deleteById(idPlan);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ClientePlan> listarId(int idClientePlan) {
		return dClientePlan.findById(idClientePlan);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientePlan> listar() {
		return dClientePlan.findAll();
	}

	@Override
	@Transactional
	public List<ClientePlan> findByNombrePlan(String nombreCliente) {
		List<ClientePlan> lista=dClientePlan.findByNombreCliente(nombreCliente);
		
		return lista;
	}

	

	
}
