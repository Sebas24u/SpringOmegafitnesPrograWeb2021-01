package pe.edu.upc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "redirect:/cliente/listar";
	}

	
	
	
}
