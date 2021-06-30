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
import pe.edu.upc.model.Gimnasio;
import pe.edu.upc.service.IGimnasioService;
import pe.edu.upc.model.Sala;
import pe.edu.upc.service.ISalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {

	@Autowired
	private ISalaService sService;
	
	@Autowired
	private IGimnasioService gService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoSalas(Model model) {
		model.addAttribute("sala", new Sala());
		model.addAttribute("listaSalas", sService.listar());
		return "sala/listSala";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		

		model.addAttribute("sala", new Sala());
		return "sala/sala";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Sala objSala, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors()) {
			model.addAttribute("listaGimnasios", gService.listar());
		return "sala/sala";}
		else {
			boolean flag = sService.insertar(objSala);
			if (flag)
				return "redirect:/sala/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/sala/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Sala> objSala= sService.listarId(id);
		if(objSala == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/sala/listar";
		}
		else {
			model.addAttribute("listaGimnasios", gService.listar());
			
			if(objSala.isPresent())
				objSala.ifPresent(o-> model.addAttribute("sala",o));
			
			return "sala/sala";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				sService.eliminar(id);
				model.put("sala", new Sala());
				model.put("listaSalas", sService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("sala", new Sala());
			model.put("listaSalas", sService.listar());
		}
		return "sala/listSala";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("sala", new Sala());
		model.addAttribute("listaSalas", sService.listar());
		return "sala/listSala";
	}
}
