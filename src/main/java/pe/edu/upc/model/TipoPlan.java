package pe.edu.upc.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TipoPlan")
public class TipoPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoPlan;
	
	@Column(name="nombreTipoPlan", nullable = false, length=30)
	private String nombreTipoPlan;
	

	public TipoPlan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TipoPlan(int idTipoPlan, String nombreTipoPlan) {
		super();
		this.idTipoPlan = idTipoPlan;
		this.nombreTipoPlan = nombreTipoPlan;
	}


	public int getIdTipoPlan() {
		return idTipoPlan;
	}


	public void setIdTipoPlan(int idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}


	public String getNombreTipoPlan() {
		return nombreTipoPlan;
	}


	public void setNombreTipoPlan(String nombreTipoPlan) {
		this.nombreTipoPlan = nombreTipoPlan;
	}
	
	
	
	
}
