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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Salud")
public class Salud implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSalud;
	

	@ManyToOne
	@JoinColumn(name="idCliente",nullable=false)
	private Cliente cliente;
	
	@Column(name="peso", nullable = false, length=30)
	private Double peso;
	
	@Column(name = "estatura", nullable = false, length=50)
	private Double estatura;
	
	@Transient
	private Double imc;

	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaSalud", nullable=false,length = 50)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaSalud;
	
	public Salud() {
		super();
		// TODO Auto-generated constructor stub
	}

	




	public Salud(int idSalud, Cliente cliente, Double peso, Double estatura, Double imc, Date fechaSalud) {
		super();
		this.idSalud = idSalud;
		this.cliente = cliente;
		this.peso = peso;
		this.estatura = estatura;
		this.imc = imc;
		this.fechaSalud = fechaSalud;
	}






	public int getIdSalud() {
		return idSalud;
	}

	public void setIdSalud(int idSalud) {
		this.idSalud = idSalud;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}


	public Date getFechaSalud() {
		return fechaSalud;
	}

	public void setFechaSalud(Date fechaSalud) {
		this.fechaSalud = fechaSalud;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}






	public double getImc() {
		return imc;
	}






	public void setImc(Double imc) {
		this.imc = imc;
	}
	
	
	
	
}
