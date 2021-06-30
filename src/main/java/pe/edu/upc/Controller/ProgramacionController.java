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




import pe.edu.upc.model.Programacion;
import pe.edu.upc.service.IProgramacionService;

import pe.edu.upc.model.Actividad;
import pe.edu.upc.service.IActividadService;

@Controller
@RequestMapping("/programacion")
public class ProgramacionController {
	
	@Autowired
	private IProgramacionService pService;
	
	
	@Autowired
	private IActividadService aService;
	
	
	@RequestMapping("/bienvenido")
	public String irPlanBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoProgramaciones(Model model) {
		model.addAttribute("programacion", new Programacion());
		model.addAttribute("listaProgramaciones", pService.listar());
		return "programacion/listProgramacion";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaActividades", aService.listar());
		
		model.addAttribute("programacion", new Programacion());
		model.addAttribute("actividad", new Actividad());
		
		return "programacion/programacion";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Programacion objProgramacion, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
		{
			model.addAttribute("listaActividades", pService.listar());
			
			return "programacion/programacion";}
		else {
			boolean flag = pService.insertar(objProgramacion);
			if (flag)
				return "redirect:/programacion/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/programacion/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Programacion> objProgramacion = pService.listarId(id);
		if(objProgramacion == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/programacion/listar";
		}
		else {
			model.addAttribute("listaActividades", aService.listar());
			
			if(objProgramacion.isPresent())
				objProgramacion.ifPresent(o-> model.addAttribute("programacion",o));
			
			return "programacion/programacion";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				pService.eliminar(id);
				model.put("programacion", new Programacion());
				model.put("listaProgramaciones", pService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("programacion", new Programacion());
			model.put("listaProgramaciones", pService.listar());
		}
		return "programacion/listProgramacion";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("programacion", new Programacion());
		model.addAttribute("listaProgramaciones", pService.listar());
		return "programacion/listProgramacion";
	}
	
	/*@RequestMapping("/irBuscar")
	public String irPaginaBuscar(Model model ) {
		model.addAttribute("listaActividadeses", aService.listar());
		
		model.addAttribute("programacion", new Programacion());
		model.addAttribute("actividad", new Actividad());
		
		return "programacion/programacionbuscar";
	}
	*/
	

	
}
