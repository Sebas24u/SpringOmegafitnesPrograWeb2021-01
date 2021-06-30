package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.auth.handler.LoginSuccessHandler;
import pe.edu.upc.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		

	    String[] resources = new String[]{
	            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
	    };
		try {
			http.authorizeRequests()
			.antMatchers(resources).permitAll()  
	        .antMatchers("/","/index").permitAll()
			.antMatchers("/","/about-us").permitAll()
			.antMatchers("/actividadCliente/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/actividad/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/administrador/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/alimentacion/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/cliente/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/clienteplan/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/entrenador/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/gimnasio/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/plan/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/programacion/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/rutinacliente/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/rutina/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/sala/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/salud/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
			.antMatchers("/tipodocumento/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/tipoplan/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/welcome/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_ENTRENADOR')").and()
			.formLogin().successHandler(successHandler).loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/welcome/bienvenido")
			.permitAll().and().logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception{
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}
