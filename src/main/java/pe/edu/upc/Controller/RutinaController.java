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

import pe.edu.upc.model.Entrenador;
import pe.edu.upc.model.Rutina;
import pe.edu.upc.service.IRutinaService;

@Controller
@RequestMapping("/rutina")
public class RutinaController {
	
	@Autowired
	private IRutinaService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRutinas(Model model) {
		model.addAttribute("rutina", new Rutina());
		model.addAttribute("listaRutinas", rService.listar());
		return "rutina/listRutina";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("rutina", new Rutina());
		return "rutina/rutina";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Rutina objRutina, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
			return "rutina/rutina";
		else {
			boolean flag = rService.insertar(objRutina);
			if (flag)
				return "redirect:/rutina/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/rutina/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Rutina> objRutina = rService.listarId(id);
		if(objRutina == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/rutina/listar";
		}
		else {
			model.addAttribute("rutina", objRutina);
			return "rutina/rutina";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("rutina", new Rutina());
				model.put("listaRutinas", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("rutina", new Rutina());
			model.put("listaRutinas", rService.listar());
		}
		return "rutina/listRutina";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("rutina", new Rutina());
		model.addAttribute("listaRutinas", rService.listar());
		return "rutina/listRutina";
	}
	
	
	
	
}
