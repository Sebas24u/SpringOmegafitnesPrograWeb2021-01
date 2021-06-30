package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Administrador")
public class Administrador implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	
	@Column(name="nombreAdministrador", nullable = false, length=30)
	private String nombreAdministrador;
	@Column(name = "apellidoAdministrador", nullable = false, length=30)
	private String apellidoAdministrador;
	
	@Column(name = "documentoAdministrador", nullable = false, length=30)
	private String documentoAdministrador;
	
	@Column(name = "direccionAdministrador", nullable = false, length=50)
	private String direccionAdministrador;
	
	@Column(name = "telefonoAdministrador", nullable = false, length=30)
	private String telefonoAdministrador;
	
	@Column(name = "correoAdministrador", nullable = false, length=50)
	private String correoAdministrador;
	
	public Administrador() {
		super();
	}

	public Administrador(int idAdministrador, String nombreAdministrador, String apellidoAdministrador,
			String documentoAdministrador, String direccionAdministrador, String telefonoAdministrador,
			String correoAdministrador) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombreAdministrador = nombreAdministrador;
		this.apellidoAdministrador = apellidoAdministrador;
		this.documentoAdministrador = documentoAdministrador;
		this.direccionAdministrador = direccionAdministrador;
		this.telefonoAdministrador = telefonoAdministrador;
		this.correoAdministrador = correoAdministrador;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getApellidoAdministrador() {
		return apellidoAdministrador;
	}

	public void setApellidoAdministrador(String apellidoAdministrador) {
		this.apellidoAdministrador = apellidoAdministrador;
	}

	public String getDocumentoAdministrador() {
		return documentoAdministrador;
	}

	public void setDocumentoAdministrador(String documentoAdministrador) {
		this.documentoAdministrador = documentoAdministrador;
	}

	public String getDireccionAdministrador() {
		return direccionAdministrador;
	}

	public void setDireccionAdministrador(String direccionAdministrador) {
		this.direccionAdministrador = direccionAdministrador;
	}

	public String getTelefonoAdministrador() {
		return telefonoAdministrador;
	}

	public void setTelefonoAdministrador(String telefonoAdministrador) {
		this.telefonoAdministrador = telefonoAdministrador;
	}

	public String getCorreoAdministrador() {
		return correoAdministrador;
	}

	public void setCorreoAdministrador(String correoAdministrador) {
		this.correoAdministrador = correoAdministrador;
	}

	
}
	

	