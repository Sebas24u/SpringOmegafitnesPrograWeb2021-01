package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Rutina")
public class Rutina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRutina;
	
	@Column(name="nombreRutina", length = 60, nullable=false)
	private String nameRutina;

	@Column(name="Descripcion", length = 60, nullable=false)
	private String descripcion;
	
	@Column(name="Frecuencia", length = 60, nullable=false)
	private String frecuencia;
	
	@Column(name="Duracion", length = 60, nullable=false)
	private String duracion;
	
	
	public Rutina() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Rutina(int idRutina, String nameRutina, String descripcion, String frecuencia, String duracion) {
		super();
		this.idRutina = idRutina;
		this.nameRutina = nameRutina;
		this.descripcion = descripcion;
		this.frecuencia = frecuencia;
		this.duracion = duracion;
	}


	public int getIdRutina() {
		return idRutina;
	}


	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}


	public String getNameRutina() {
		return nameRutina;
	}


	public void setNameRutina(String nameRutina) {
		this.nameRutina = nameRutina;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFrecuencia() {
		return frecuencia;
	}


	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	
	
}
