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



import pe.edu.upc.model.Alimentacion;
import pe.edu.upc.model.Entrenador;
import pe.edu.upc.service.IAlimentacionService;

@Controller
@RequestMapping("/alimentacion")
public class AlimentacionController {
	
	@Autowired
	private IAlimentacionService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoAlimentaciones(Model model) {
		model.addAttribute("alimentacion", new Alimentacion());
		model.addAttribute("listaAlimentaciones", rService.listar());
		return "alimentacion/listAlimentacion";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("alimentacion", new Alimentacion());
		return "alimentacion/alimentacion";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Alimentacion objAlimentacion, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
			return "alimentacion/alimentacion";
		else {
			boolean flag = rService.insertar(objAlimentacion);
			if (flag)
				return "redirect:/alimentacion/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/alimentacion/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Alimentacion> objAlimentacion = rService.listarId(id);
		if(objAlimentacion == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/alimentacion/listar";
		}
		else {
			model.addAttribute("alimentacion", objAlimentacion);
			return "alimentacion/alimentacion";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("alimentacion", new Alimentacion());
				model.put("listaAlimentaciones", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("alimentacion", new Alimentacion());
			model.put("listaAlimentaciones", rService.listar());
		}
		return "alimentacion/listAlimentacion";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("alimentacion", new Alimentacion());
		model.addAttribute("listaAlimentaciones", rService.listar());
		return "alimentacion/listAlimentacion";
	}
	
	
	
	
}
