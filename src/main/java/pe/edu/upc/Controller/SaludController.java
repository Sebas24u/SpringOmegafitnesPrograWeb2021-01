package pe.edu.upc.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.upc.model.Cliente;
import pe.edu.upc.model.Entrenador;
import pe.edu.upc.model.Plan;
import pe.edu.upc.model.Salud;
import pe.edu.upc.model.TipoPlan;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.ISaludService;

@Controller
@RequestMapping("/salud")
public class SaludController {
	
	@Autowired
	private ISaludService sService;
	
	@Autowired
	private IClienteService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoSaludes(Model model) {
		model.addAttribute("salud", new Salud());
		model.addAttribute("listaSaludes", sService.listar());
		return "salud/listSalud";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
	
		model.addAttribute("listaClientes", cService.listar());
		
		model.addAttribute("salud", new Salud());
		model.addAttribute("cliente", new Cliente());
		return "salud/salud";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Salud objSalud, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors()) {
			model.addAttribute("listaClientes", cService.listar());
			return "salud/salud";
		}
		else {
			boolean flag = sService.insertar(objSalud);
			if (flag)
				return "redirect:/salud/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/salud/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Salud> objSalud = sService.listarId(id);
		if(objSalud == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/salud/listar";
		}
		else {
			model.addAttribute("listaClientes", cService.listar());
			
			if(objSalud.isPresent())
				objSalud.ifPresent(o-> model.addAttribute("salud",o));
		//	model.addAttribute("salud", objSalud);
			return "salud/salud";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				sService.eliminar(id);
				model.put("listaSaludes", sService.listar());
				model.put("salud", new Salud());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("salud", new Salud());
			model.put("listaSaludes", sService.listar());
		}
		return "salud/listSalud";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("salud", new Salud());
		model.addAttribute("listaSaludes", sService.listar());
		return "salud/listSalud";
	}
	/*@RequestMapping("/irBuscar")
	public String irPaginaBuscar(Model model ) {
		model.addAttribute("listaSaludes", sService.listar());
		
		model.addAttribute("salud", new Salud());
		model.addAttribute("cliente", new Cliente());
		
		return "salud/saludbuscar";
	}
	
	
	@RequestMapping("/saludbuscar")
	public String findbyPlan(Map<String, Object> model,
			@ModelAttribute Salud salud ) throws Exception {
		List<Salud> listaSaludes;
		salud.getCliente().setNombreCliente(salud.getCliente().getNombreCliente());
		listaSaludes = sService.findByNombreCliente(salud.getCliente().getNombreCliente());
		model.put("listaSaludes",listaSaludes);
		return "salud/saludbuscar";
	}*/
}
