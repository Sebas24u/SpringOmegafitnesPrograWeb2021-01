package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ClientePlan")
public class ClientePlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idClientePlan;

	@ManyToOne
	@JoinColumn(name="idPlan",nullable=false)
	private Plan plan;
	
	@ManyToOne
	@JoinColumn(name="idCliente",nullable=false)
	private Cliente cliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaClientePlan", nullable=false,length = 50)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaClientePlan;


	public ClientePlan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClientePlan(int idClientePlan, Plan plan, Cliente cliente, Date fechaClientePlan) {
		super();
		this.idClientePlan = idClientePlan;
		this.plan = plan;
		this.cliente = cliente;
		this.fechaClientePlan = fechaClientePlan;
	}


	public int getIdClientePlan() {
		return idClientePlan;
	}


	public void setIdClientePlan(int idClientePlan) {
		this.idClientePlan = idClientePlan;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Date getFechaClientePlan() {
		return fechaClientePlan;
	}


	public void setFechaClientePlan(Date fechaClientePlan) {
		this.fechaClientePlan = fechaClientePlan;
	}

	


	
	
	
}
