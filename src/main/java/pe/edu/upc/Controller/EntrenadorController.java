package pe.edu.upc.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.Exception.CustomeFieldValidationException;

import pe.edu.upc.model.Entrenador;
import pe.edu.upc.service.IEntrenadorService;
import pe.edu.upc.service.IUploadFileService;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorController {
	
	@Autowired
	private IEntrenadorService rService;
	
	@Autowired
	private IUploadFileService uploadFileService;
	
	@RequestMapping("/bienvenido")
	public String irEntrenadorBienvenida() {
		return "bienvenido";
	}
	
	
	@RequestMapping("/")
	public String irPaginaListadoEntrenadores( Model model) {
		model.addAttribute("entrenador", new Entrenador());
		model.addAttribute("listaEntrenadores", rService.listar());
		return "entrenador/listEntrenador";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("entrenador", new Entrenador());
		return "entrenador/entrenador";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@Validated Entrenador entrenador, BindingResult binRes, Model model, @RequestParam("file")MultipartFile imagen,RedirectAttributes flash) throws Exception {
		if (binRes.hasErrors())
			return "entrenador/entrenador";
		else {
			if (!imagen.isEmpty()) {
				
				Path directorimagen= Paths.get("src//main//resources//static/img");
			
				String rutaAbsoluta = directorimagen.toFile().getAbsolutePath();
				byte[] bytesImg = imagen.getBytes();
				
				Path rutacompleta=Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutacompleta, bytesImg);
				
				entrenador.setImagen(imagen.getOriginalFilename());

				/*if (entrenador.getIdEntrenador() > 0 && entrenador.getImagen() != null && entrenador.getImagen().length() > 0) {

					uploadFileService.delete(entrenador.getImagen());
				}

				String uniqueFilename = null;
				try {
					uniqueFilename = uploadFileService.copy(imagen);
				} catch (IOException e) {
					e.printStackTrace();
				}

				flash.addFlashAttribute("info", "Has subido correctamente '" + uniqueFilename + "'");
				entrenador.setImagen(uniqueFilename);*/
			}
			boolean flag = rService.insertar(entrenador);
			if (flag)
				return "redirect:/entrenador/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/entrenador/irRegistrar";
			}
		}
	/*	if(!imagen.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static/imgEntrenadores");
		}*/
		
	}
	
	@RequestMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") int idEntrenador, Model model, RedirectAttributes objRedir) throws Exception {

		Entrenador entrenador=null;
		if(idEntrenador > 0)
		{
			entrenador= rService.buscarporID(idEntrenador);
			if(entrenador == null)
			{	
				objRedir.addFlashAttribute("mensaje", "El ID del Entrenador no  existe");
				return "redirect:/entrenador/listar";
			}
		}
		else
		{
			
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error con el Id del Entrenador");
			return "redirect:/entrenador/listar";
		}
		
		model.addAttribute("entrenador", entrenador);
		return "entrenador/detalleEntrenador";
		
	/*	Optional<Entrenador> objEntrenador = rService.listarId(idEntrenador);
		if(objEntrenador == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/entrenador/listar";
		}
		else {
			
			model.addAttribute("entrenador", objEntrenador);
			return "entrenador/entrenador";
		}*/
	}
	
	
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Entrenador> objEntrenador = rService.listarId(id);
		if(objEntrenador == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/entrenador/listar";
		}
		else {
			
			model.addAttribute("entrenador", objEntrenador);
			return "entrenador/entrenador";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("entrenador", new Entrenador());
				model.put("listaEntrenadores", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("entrenador", new Entrenador());
			model.put("listaEntrenadores", rService.listar());
		}
		return "entrenador/listEntrenador";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("entrenador", new Entrenador());
		model.addAttribute("listaEntrenadores", rService.listar());
		return "entrenador/listEntrenador";
	}
	
	@GetMapping(value = "/uploads/{filename:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

		Resource recurso = null;

		try {
			recurso = uploadFileService.load(filename);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
				.body(recurso);
	}
	
	
	
}
