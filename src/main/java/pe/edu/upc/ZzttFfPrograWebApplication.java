package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ZzttFfPrograWebApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ZzttFfPrograWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String password = "admin";
		String contra = "entrenador";
		String contra2 = "user";
		
		
		for (int i=0;i<2;i++) {
			String bcryptPassword= passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
		
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(contra);
			System.out.println(bcryptPassword);
		}
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(contra2);
			System.out.println(bcryptPassword);
		}
	}
	
}
