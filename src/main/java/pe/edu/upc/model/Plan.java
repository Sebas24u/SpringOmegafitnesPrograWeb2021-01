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
@Table(name="Plan")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	
	@Column(name="nombrePlan", length = 60, nullable=false)
	private String nombrePlan;

	@Column(name="PrecioPlan", length = 60, nullable=false)
	private String PrecioPlan;
	
	@Column(name="DescripcionPlan", length = 60, nullable=false)
	private String DescripcionPlan;
	
	@Column(name="Duracion", length = 60, nullable=false)
	private String duracion;
	
	@ManyToOne
	@JoinColumn(name="idTipoPlan",nullable=false)
	private TipoPlan tipoplan;
	
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plan(int idPlan, String nombrePlan, String precioPlan, String descripcionPlan, String duracion,
			TipoPlan tipoplan) {
		super();
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		PrecioPlan = precioPlan;
		DescripcionPlan = descripcionPlan;
		this.duracion = duracion;
		this.tipoplan = tipoplan;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public String getPrecioPlan() {
		return PrecioPlan;
	}

	public void setPrecioPlan(String precioPlan) {
		PrecioPlan = precioPlan;
	}

	public String getDescripcionPlan() {
		return DescripcionPlan;
	}

	public void setDescripcionPlan(String descripcionPlan) {
		DescripcionPlan = descripcionPlan;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public TipoPlan getTipoplan() {
		return tipoplan;
	}

	public void setTipoplan(TipoPlan tipoplan) {
		this.tipoplan = tipoplan;
	}


	
	
	
}
