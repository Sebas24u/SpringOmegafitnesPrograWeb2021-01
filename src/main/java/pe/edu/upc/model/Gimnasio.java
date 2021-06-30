package pe.edu.upc.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Gimnasio")
public class Gimnasio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGimnasio;
	
	@Column(name="nombreGimnasio", nullable = false, length=30)
	private String nombreGimnasio;
	
	@Column(name="gimnasioDistrito", nullable = false, length=30)
	private String gimnasioDistrito;
	
	@Column(name = "direccionGimnasio", nullable = false, length=50)
	private String direccionGimnasio;

	@Column(name = "telefonoGimnasio", nullable = false, length=50)
	private String telefonoGimnasio;

	@Column(name = "correoGimnasio", nullable = false, length=50)
	private String correoGimnasio;
	

	public Gimnasio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Gimnasio(int idGimnasio, String nombreGimnasio, String gimnasioDistrito, String direccionGimnasio,
			String telefonoGimnasio, String correoGimnasio) {
		super();
		this.idGimnasio = idGimnasio;
		this.nombreGimnasio = nombreGimnasio;
		this.gimnasioDistrito = gimnasioDistrito;
		this.direccionGimnasio = direccionGimnasio;
		this.telefonoGimnasio = telefonoGimnasio;
		this.correoGimnasio = correoGimnasio;
	}


	public int getIdGimnasio() {
		return idGimnasio;
	}


	public void setIdGimnasio(int idGimnasio) {
		this.idGimnasio = idGimnasio;
	}


	public String getNombreGimnasio() {
		return nombreGimnasio;
	}


	public void setNombreGimnasio(String nombreGimnasio) {
		this.nombreGimnasio = nombreGimnasio;
	}


	public String getGimnasioDistrito() {
		return gimnasioDistrito;
	}


	public void setGimnasioDistrito(String gimnasioDistrito) {
		this.gimnasioDistrito = gimnasioDistrito;
	}


	public String getDireccionGimnasio() {
		return direccionGimnasio;
	}


	public void setDireccionGimnasio(String direccionGimnasio) {
		this.direccionGimnasio = direccionGimnasio;
	}


	public String getTelefonoGimnasio() {
		return telefonoGimnasio;
	}


	public void setTelefonoGimnasio(String telefonoGimnasio) {
		this.telefonoGimnasio = telefonoGimnasio;
	}


	public String getCorreoGimnasio() {
		return correoGimnasio;
	}


	public void setCorreoGimnasio(String correoGimnasio) {
		this.correoGimnasio = correoGimnasio;
	}
	
	

	
}
