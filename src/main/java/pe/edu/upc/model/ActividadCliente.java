package pe.edu.upc.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ActividadCliente")
public class ActividadCliente implements Serializable {
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActividadCliente;
	
	@ManyToOne
	@JoinColumn(name="idCliente",nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idActividad",nullable=false)
	private Actividad actividad;

	public ActividadCliente() {
		super();
	}

	public ActividadCliente(int idActividadCliente, Cliente cliente, Actividad actividad) {
		super();
		this.idActividadCliente = idActividadCliente;
		this.cliente = cliente;
		this.actividad = actividad;
	}

	public int getIdActividadCliente() {
		return idActividadCliente;
	}

	public void setIdActividadCliente(int idActividadCliente) {
		this.idActividadCliente = idActividadCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
}
