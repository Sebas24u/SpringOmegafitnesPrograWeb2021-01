package pe.edu.upc.Controller;

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



import pe.edu.upc.model.Actividad;
import pe.edu.upc.model.Entrenador;
import pe.edu.upc.service.IActividadService;
import pe.edu.upc.service.ISalaService;
import pe.edu.upc.model.Sala;

@Controller
@RequestMapping("/actividad")
public class ActividadController {

	@Autowired
	private IActividadService aService;
	
	@Autowired
	private ISalaService sService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoActividades(Model model) {
		model.addAttribute("actividad", new Actividad());
		model.addAttribute("listaActividades", aService.listar());
		return "actividad/listActividad";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaSalas", sService.listar());
		
		model.addAttribute("sala", new Sala());
		model.addAttribute("actividad", new Actividad());
		return "actividad/actividad";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Actividad objActividad, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors()) {
			model.addAttribute("listaSalas", sService.listar());
		return "actividad/actividad";}
		else {
			boolean flag = aService.insertar(objActividad);
			if (flag)
				return "redirect:/actividad/listar";
			else {
				
				
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/actividad/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Actividad> objActividad = aService.listarId(id);
		if(objActividad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/actividad/listar";
		}
		else {
			
			model.addAttribute("listaSalas", sService.listar());
			if(objActividad.isPresent())
				objActividad.ifPresent(o-> model.addAttribute("actividad",o));
			
			return "actividad/actividad";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				aService.eliminar(id);
				model.put("actividad", new Actividad());
				model.put("listaActividades", aService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("actividad", new Actividad());
			model.put("listaActividades", aService.listar());
		}
		return "actividad/listActividad";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("actividad", new Actividad());
		model.addAttribute("listaActividades", aService.listar());
		return "actividad/listActividad";
	}
	
	
}
