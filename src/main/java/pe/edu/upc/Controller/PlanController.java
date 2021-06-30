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

import pe.edu.upc.model.Entrenador;
import pe.edu.upc.model.Plan;
import pe.edu.upc.service.IPlanService;

import pe.edu.upc.model.TipoPlan;
import pe.edu.upc.service.ITipoPlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private IPlanService pService;
	
	
	@Autowired
	private ITipoPlanService tService;
	
	
	@RequestMapping("/bienvenido")
	public String irPlanBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoPlanes(Model model) {
		model.addAttribute("plan", new Plan());
		model.addAttribute("listaPlanes", pService.listar());
		return "plan/listPlan";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		
		model.addAttribute("listaTipoPlanes", tService.listar());
		
		model.addAttribute("plan", new Plan());
		model.addAttribute("tipoplan", new TipoPlan());
		
		return "plan/plan";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Plan objPlan, BindingResult binRes, Model model) throws Exception {
		if (binRes.hasErrors())
		{
			model.addAttribute("listaTipoPlanes", tService.listar());
			
			return "plan/plan";}
		else {
			boolean flag = pService.insertar(objPlan);
			if (flag)
				return "redirect:/plan/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/plan/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws Exception {
		Optional<Plan> objPlan = pService.listarId(id);
		if(objPlan == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/plan/listar";
		}
		else {
			model.addAttribute("listaTipoPlanes", tService.listar());
			
			if(objPlan.isPresent())
				objPlan.ifPresent(o-> model.addAttribute("plan",o));
			
			return "plan/plan";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				pService.eliminar(id);
				model.put("plan", new Plan());
				model.put("listaPlanes", pService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("plan", new Plan());
			model.put("listaPlanes", pService.listar());
		}
		return "plan/listPlan";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("plan", new Plan());
		model.addAttribute("listaPlanes", pService.listar());
		return "plan/listPlan";
	}
	
	/*@RequestMapping("/irBuscar")
	public String irPaginaBuscar(Model model ) {
		model.addAttribute("listaTipoPlanes", tService.listar());
		
		model.addAttribute("plan", new Plan());
		model.addAttribute("tipoplan", new TipoPlan());
		
		return "plan/planbuscar";
	}
	
	
	@RequestMapping("/planbuscar")
	public String findbyPlan(Model model,
			@ModelAttribute Plan plan ) throws Exception {
		List<Plan> listaPlanes;
		plan.setNombrePlan(plan.getNombrePlan());
		listaPlanes = pService.findByNombrePlan(plan.getNombrePlan());
		model.addAttribute("plan", new Plan());
		model.addAttribute("listaPlanes",listaPlanes);
		return "plan/planbuscar";
	}*/
	
}
