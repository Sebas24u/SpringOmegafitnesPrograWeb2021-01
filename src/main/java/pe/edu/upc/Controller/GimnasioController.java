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



import pe.edu.upc.model.Gimnasio;
import pe.edu.upc.service.IGimnasioService;

@Controller
@RequestMapping("/gimnasio")
public class GimnasioController {
	
	@Autowired
	private IGimnasioService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoGimnasios(Map<String, Object> model) {
		model.put("listaGimnasios", rService.listar());
		return "listGimnasio";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("gimnasio", new Gimnasio());
		return "gimnasio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Gimnasio objGimnasio, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
			return "gimnasio";
		else {
			boolean flag = rService.insertar(objGimnasio);
			if (flag)
				return "redirect:/gimnasio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/gimnasio/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Gimnasio> objGimnasio = rService.listarId(id);
		if(objGimnasio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/gimnasio/listar";
		}
		else {
			model.addAttribute("gimnasio", objGimnasio);
			return "gimnasio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaGimnasios", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaGimnasios", rService.listar());
		}
		return "listGimnasio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaGimnasios", rService.listar());
		return "listGimnasio";
	}
	
	
	
	
}
