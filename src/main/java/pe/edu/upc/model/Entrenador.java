package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="Entrenador")
public class Entrenador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntrenador;
	
	@Column(name="nombreEntrenador", nullable = false, length=30)
	private String nombreEntrenador;
	@Column(name = "apellidoEntrenador", nullable = false, length=30)
	private String apellidoEntrenador;
	
	@Column(name = "documentoEntrenador", nullable = false, length=50)
	private String documentoEntrenador;
	
	@Column(name = "direccionEntrenador", nullable = false, length=50)
	private String direccionEntrenador;
	
	@Column(name = "telefonoEntrenador", nullable = false, length=50)
	private String telefonoEntrenador;
	
	@Email
	@NotEmpty
	@Column(name = "correoEntrenador", nullable = false, length=50)
	private String correoEntrenador;
	
	@Column(name = "estudiosEntrenador", nullable = false, length=50)
	private String estudiosEntrenador;
	
	private String imagen;
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Entrenador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrenador(int idEntrenador, String nombreEntrenador, String apellidoEntrenador, String documentoEntrenador,
			String direccionEntrenador, String telefonoEntrenador, String correoEntrenador, String estudiosEntrenador) {
		super();
		this.idEntrenador = idEntrenador;
		this.nombreEntrenador = nombreEntrenador;
		this.apellidoEntrenador = apellidoEntrenador;
		this.documentoEntrenador = documentoEntrenador;
		this.direccionEntrenador = direccionEntrenador;
		this.telefonoEntrenador = telefonoEntrenador;
		this.correoEntrenador = correoEntrenador;
		this.estudiosEntrenador = estudiosEntrenador;
	}

	public int getIdEntrenador() {
		return idEntrenador;
	}

	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getApellidoEntrenador() {
		return apellidoEntrenador;
	}

	public void setApellidoEntrenador(String apellidoEntrenador) {
		this.apellidoEntrenador = apellidoEntrenador;
	}

	public String getDocumentoEntrenador() {
		return documentoEntrenador;
	}

	public void setDocumentoEntrenador(String documentoEntrenador) {
		this.documentoEntrenador = documentoEntrenador;
	}

	public String getDireccionEntrenador() {
		return direccionEntrenador;
	}

	public void setDireccionEntrenador(String direccionEntrenador) {
		this.direccionEntrenador = direccionEntrenador;
	}

	public String getTelefonoEntrenador() {
		return telefonoEntrenador;
	}

	public void setTelefonoEntrenador(String telefonoEntrenador) {
		this.telefonoEntrenador = telefonoEntrenador;
	}

	public String getCorreoEntrenador() {
		return correoEntrenador;
	}

	public void setCorreoEntrenador(String correoEntrenador) {
		this.correoEntrenador = correoEntrenador;
	}

	public String getEstudiosEntrenador() {
		return estudiosEntrenador;
	}

	public void setEstudiosEntrenador(String estudiosEntrenador) {
		this.estudiosEntrenador = estudiosEntrenador;
	}

	
	

	
	
	
}
