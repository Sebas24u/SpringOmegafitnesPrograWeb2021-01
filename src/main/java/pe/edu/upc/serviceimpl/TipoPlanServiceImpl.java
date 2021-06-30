package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.TipoPlan;
import pe.edu.upc.repository.ITipoPlanRepository;
import pe.edu.upc.service.ITipoPlanService;

@Service
public class TipoPlanServiceImpl implements ITipoPlanService {

	@Autowired
	private ITipoPlanRepository tTipoPlan;
	
	@Override
	@Transactional
	public boolean insertar(TipoPlan tipoplan) {
		TipoPlan objTipoPlan = tTipoPlan.save(tipoplan);
		if(objTipoPlan == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TipoPlan tipoplan) {
		boolean flag = false;
		try {
			tTipoPlan.save(tipoplan);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un problema");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idTipoPlan) {
		tTipoPlan.deleteById(idTipoPlan);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoPlan> listarId(int idTipoPlan) {
		return tTipoPlan.findById(idTipoPlan);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoPlan> listar() {
		return tTipoPlan.findAll();
	}

	@Override
	@Transactional
	public List<TipoPlan> buscarNombre(String nameTipoPlan) {
		return tTipoPlan.buscarNombre(nameTipoPlan);
	}
	
}
