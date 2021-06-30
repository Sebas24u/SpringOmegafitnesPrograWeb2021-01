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




import pe.edu.upc.model.RutinaCliente;
import pe.edu.upc.service.IRutinaClienteService;

import pe.edu.upc.model.Rutina;
import pe.edu.upc.service.IRutinaService;

import pe.edu.upc.model.Cliente;
import pe.edu.upc.model.Entrenador;
import pe.edu.upc.service.IClienteService;

@Controller
@RequestMapping("/rutinacliente")
public class RutinaClienteController {
	
	@Autowired
	private IRutinaClienteService cpService;
	
	
	@Autowired
	private IRutinaService tService;

	@Autowired
	private IClienteService cService;
	
	@RequestMapping("/bienvenido")
	public String irPlanBienvenida() {
		return "rutinacliente/bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRutinaClientes(Model model) {
		model.addAttribute("rutinacliente", new RutinaCliente());
		model.addAttribute("listaRutinaClientes", cpService.listar());
		return "rutinacliente/listRutinaCliente";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaRutinas", tService.listar());
		model.addAttribute("listaClientes", cService.listar());
		
		model.addAttribute("rutinacliente", new RutinaCliente());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("rutina", new Rutina());
		
		return "rutinacliente/rutinacliente";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute RutinaCliente objRutinaCliente, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
		{
			model.addAttribute("listaRutinas", tService.listar());
			model.addAttribute("listaClientes", cService.listar());
			
			return "rutinacliente/rutinacliente";}
		else {
			boolean flag = cpService.insertar(objRutinaCliente);
			if (flag)
				return "redirect:/rutinacliente/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/rutinacliente/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<RutinaCliente> objRutinaCliente = cpService.listarId(id);
		if(objRutinaCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/rutinacliente/listar";
		}
		else {
			model.addAttribute("listaRutinas", tService.listar());
			model.addAttribute("listaClientes", cService.listar());
			
			
			if(objRutinaCliente.isPresent())
				objRutinaCliente.ifPresent(o-> model.addAttribute("rutinacliente",o));
			
			return "rutinacliente/rutinacliente";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				cpService.eliminar(id);
				model.put("rutinacliente", new RutinaCliente());
				model.put("listaRutinaClientes", cpService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("rutinacliente", new RutinaCliente());
			model.put("listaRutinaClientes", cpService.listar());
		}
		return "rutinacliente/listRutinaCliente";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("rutinacliente", new RutinaCliente());
		model.addAttribute("listaRutinaClientes", cpService.listar());
		return "rutinacliente/listRutinaCliente";
	}
	
	/*	@RequestMapping("/irBuscar")
	public String irPaginaBuscar(Model model ) {
		
		model.addAttribute("listaRutinas", tService.listar());
		model.addAttribute("listaClientes", cService.listar());
		
		model.addAttribute("rutinacliente", new RutinaCliente());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("rutina", new Rutina());
		
		
		return "rutinacliente/rutinaclientebuscar";
		
		
	}
	
	
	@RequestMapping("/rutinaclientebuscar")
	public String findbyPlan(Map<String, Object> model,
			@ModelAttribute RutinaCliente rutinacliente ) throws ParseException {
		List<RutinaCliente> listaRutinaClientes;
		rutinacliente.getCliente().setNombreCliente(rutinacliente.getCliente().getNombreCliente());
		listaRutinaClientes = cpService.findByNombreCliente(rutinacliente.getCliente().getNombreCliente());
		model.put("listaRutinaClientes",listaRutinaClientes);
		return "rutinaclientebuscar";
	}
	*/
}
