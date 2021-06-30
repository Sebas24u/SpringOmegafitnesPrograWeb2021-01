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


import pe.edu.upc.model.TipoDocumento;
import pe.edu.upc.service.ITipoDocumentoService;

@Controller
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {
	
	@Autowired
	private ITipoDocumentoService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDocumentos(Map<String, Object> model) {
		model.put("listaTipoDocumentos", rService.listar());
		return "listTipoDocumento";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("tipodocumento", new TipoDocumento());
		return "tipodocumento";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute TipoDocumento objTipoDocumento, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
			return "tipodocumento";
		else {
			boolean flag = rService.insertar(objTipoDocumento);
			if (flag)
				return "redirect:/tipodocumento/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/tipodocumento/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<TipoDocumento> objTipoDocumento = rService.listarId(id);
		if(objTipoDocumento == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/tipodocumento/listar";
		}
		else {
			model.addAttribute("tipodocumento", objTipoDocumento);
			return "tipodocumento";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaClientes", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTipoDocumentos", rService.listar());
		}
		return "listTipoDocumento";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTipoDocumentos", rService.listar());
		return "listTipoDocumento";
	}
	
	
	
	
}
