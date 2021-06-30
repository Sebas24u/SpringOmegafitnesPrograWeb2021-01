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


import pe.edu.upc.model.Administrador;
import pe.edu.upc.model.Cliente;
import pe.edu.upc.model.Entrenador;
import pe.edu.upc.model.Plan;
import pe.edu.upc.model.TipoPlan;
import pe.edu.upc.service.IAdministradorService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private IAdministradorService aService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoAdministradores(Model model) {
		model.addAttribute("administrador", new Administrador());
		model.addAttribute("listaAdministradores", aService.listar());
		return "administrador/listAdministrador";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("administrador", new Administrador());
		return "administrador/administrador";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Administrador objAdministrador, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
			return "administrador/administrador";
		else {
			boolean flag = aService.insertar(objAdministrador);
			if (flag)
				return "redirect:/administrador/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/administrador/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Administrador> objAdministrador = aService.listarId(id);
		if(objAdministrador == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/administrador/listar";
		}
		else {
			model.addAttribute("administrador", objAdministrador);
			return "administrador/administrador";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				aService.eliminar(id);
				model.put("administrador", new Administrador());
				model.put("listaAdministradores", aService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("administrador", new Administrador());
			model.put("listaAdministradores", aService.listar());
		}
		return "administrador/listAdministrador";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("administradores", new Administrador());
		model.addAttribute("listaAdministradores", aService.listar());
		return "administrador/listAdministrador";
	}
	
/*	@RequestMapping("/irBuscar")
	public String irPaginaBuscar(Model model ) {

		
		model.addAttribute("administrador", new Administrador());

		
		return "administrador/administradorbuscar";
	}*/
	
	
	/*@RequestMapping("/administradorbuscar")
	public String findbyAdministrador(Map<String, Object> model,
			@ModelAttribute  Administrador admin ) throws Exception {
		List<Administrador> listaAdministradores;
		admin.setNombreAdministrador(admin.getNombreAdministrador());
		listaAdministradores = aService.findByName(admin.getNombreAdministrador());
		model.put("listaAdministradores",listaAdministradores);
		return "administrador/administradorbuscar";
	}*/
	
}
