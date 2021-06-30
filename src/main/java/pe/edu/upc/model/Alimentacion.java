package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Alimentacion")
public class Alimentacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAlimentacion;
	
	@Column(name="nombreAlimentacion", nullable = false, length=30)
	private String nombreAlimentacion;
	@Column(name = "descripcionAlimentacion", nullable = false, length=50)
	private String descripcionAlimentacion;
	@Column(name = "duracionAlimentacion", nullable = false, length=30)
	private String duracionAlimentacion;
	public Alimentacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alimentacion(int idAlimentacion, String nombreAlimentacion, String descripcionAlimentacion,
			String duracionAlimentacion) {
		super();
		this.idAlimentacion = idAlimentacion;
		this.nombreAlimentacion = nombreAlimentacion;
		this.descripcionAlimentacion = descripcionAlimentacion;
		this.duracionAlimentacion = duracionAlimentacion;
	}
	public int getIdAlimentacion() {
		return idAlimentacion;
	}
	public void setIdAlimentacion(int idAlimentacion) {
		this.idAlimentacion = idAlimentacion;
	}
	public String getNombreAlimentacion() {
		return nombreAlimentacion;
	}
	public void setNombreAlimentacion(String nombreAlimentacion) {
		this.nombreAlimentacion = nombreAlimentacion;
	}
	public String getDescripcionAlimentacion() {
		return descripcionAlimentacion;
	}
	public void setDescripcionAlimentacion(String descripcionAlimentacion) {
		this.descripcionAlimentacion = descripcionAlimentacion;
	}
	public String getDuracionAlimentacion() {
		return duracionAlimentacion;
	}
	public void setDuracionAlimentacion(String duracionAlimentacion) {
		this.duracionAlimentacion = duracionAlimentacion;
	}
	
	
}
