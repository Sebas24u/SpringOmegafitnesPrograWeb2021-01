package pe.edu.upc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/about-us")
	public String sobrenosotros() {
		return "about-us";
	}
	
	@GetMapping("/clases")
	public String galleria() {
		return "clases";
	}
	@GetMapping("/servicios")
	public String servicios() {
		return "servicios";
	}

	@GetMapping("/team")
	public String team() {
		return "team";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

}
