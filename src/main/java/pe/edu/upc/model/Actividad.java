package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Actividad")
public class Actividad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActividad;
	
	@Column(name="nombreActividad", nullable = false, length=30)
	private String nombreActividad;
	@Column(name = "descripcionActividad", nullable = false, length=60)
	private String descripcionActividad;
	
	@ManyToOne
	@JoinColumn(name="idSala",nullable=false)
	private Sala sala;
	
	public Actividad() {
		super();
	}

	public Actividad(int idActividad, String nombreActividad, String descripcionActividad, Sala sala) {
		super();
		this.idActividad = idActividad;
		this.nombreActividad = nombreActividad;
		this.descripcionActividad = descripcionActividad;
		this.sala = sala;
	}


	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
	
