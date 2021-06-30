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



import pe.edu.upc.model.ActividadCliente;
import pe.edu.upc.service.IActividadClienteService;

@Controller
@RequestMapping("/actividadCliente")
public class ActividadClienteController {
	
	@Autowired
	private IActividadClienteService aCService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoActividadesCliente(Map<String, Object> model) {
		model.put("listaActividadesCliente", aCService.listar());
		return "listActividadCliente";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("actividadCliente", new ActividadCliente());
		return "actividadCliente";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute ActividadCliente objActividadCliente, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
		return "actividadCliente";
		else {
			boolean flag = aCService.insertar(objActividadCliente);
			if (flag)
				return "redirect:/actividadCliente/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/actividadCliente/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<ActividadCliente> objActividadCliente = aCService.listarId(id);
		if(objActividadCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/actividadCliente/listar";
		}
		else {
			model.addAttribute("actividadCliente", objActividadCliente);
			return "actividadCliente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				aCService.eliminar(id);
				model.put("listaActividadesCliente", aCService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaActividadesCliente", aCService.listar());
		}
		return "listActividadCliente";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaActividadesCliente", aCService.listar());
		return "listActividadCliente";
	}
	
}
