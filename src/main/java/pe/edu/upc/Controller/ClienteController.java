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



import pe.edu.upc.model.Cliente;

import pe.edu.upc.model.Plan;
import pe.edu.upc.service.IPlanService;
import pe.edu.upc.service.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService rService;
	
	@Autowired
	private IPlanService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoClientes(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listaClientes", rService.listar());
		return "cliente/listCliente";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("listaPlanes", pService.listar());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("plan", new Plan());
		return "cliente/cliente";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Cliente objCliente, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaPlanes", pService.listar());
			return "cliente/cliente";}
		else {
			boolean flag = rService.insertar(objCliente);
			if (flag)
				return "redirect:/cliente/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Cliente> objCliente = rService.listarId(id);
		if(objCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/cliente/listar";
		}
		else {
			
			model.addAttribute("listaPlanes", pService.listar());
			
			if(objCliente.isPresent())
				objCliente.ifPresent(o-> model.addAttribute("cliente",o));
			
			return "cliente/cliente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("cliente", new Cliente());
				model.put("listaClientes", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("entrenador", new Cliente());
			model.put("listaClientes", rService.listar());
		}
		return "cliente/listCliente";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listaClientes", rService.listar());
		return "cliente/listCliente";
	}
	
	
	
	
}
