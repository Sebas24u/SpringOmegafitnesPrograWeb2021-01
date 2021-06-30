package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.ActividadCliente;
import pe.edu.upc.repository.IActividadClienteRepository;
import pe.edu.upc.service.IActividadClienteService;

@Service
public class ActividadClienteServiceImpl implements IActividadClienteService {

	@Autowired
	private IActividadClienteRepository actividadClienteR;
	
	@Override
	@Transactional
	public boolean insertar(ActividadCliente actividadCliente) {
		ActividadCliente objActividadCliente = actividadClienteR.save(actividadCliente);
		if(objActividadCliente == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(ActividadCliente actividadCliente) {
		boolean flag = false;
		try {
			actividadClienteR.save(actividadCliente);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idActividadCliente) {
		actividadClienteR.deleteById(idActividadCliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<ActividadCliente> listarId(int idActividadCliente) {
		return actividadClienteR.findById(idActividadCliente);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ActividadCliente> listar() {
		return actividadClienteR.findAll();
	}
/*
	@Override
	@Transactional(readOnly=true)
	public List<ActividadCliente> findByName(String nombreActividadCliente) {
		List<ActividadCliente> lista = actividadClienteR.findByName(nombreActividadCliente);
		return lista;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ActividadCliente> findByNameCliente(String nombreCliente) {
		List<ActividadCliente> lista = actividadClienteR.findByNameCliente(nombreCliente);
		return lista;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ActividadCliente> findByNameActividad(String nombreActividad) {
		List<ActividadCliente> lista = actividadClienteR.findByNameActividad(nombreActividad);
		return lista;
	}*/

}
