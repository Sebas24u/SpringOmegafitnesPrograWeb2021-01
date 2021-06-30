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
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name="nombreCliente", nullable = false, length=30)
	private String nombreCliente;
	@Column(name = "apellidoCliente", nullable = false, length=30)
	private String apellidoCliente;
	@Column(name = "edadCliente", nullable = false, length=30)
	private String edadCliente;
	
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaNacimiento", nullable=false,length = 50)
	@DateTimeFormat(pattern="yyy-MM-dd")
	@Past(message = "La fecha debe ser la fecha actual o antes")
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name="idPlan",nullable=false)
	private Plan plan;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String edadCliente
			,  @Past(message = "La fecha debe ser la fecha actual o antes") Date fechaNacimiento, Plan plan) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.edadCliente = edadCliente;
		this.plan=plan;
		this.fechaNacimiento = fechaNacimiento;
		
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getEdadCliente() {
		return edadCliente;
	}
	public void setEdadCliente(String edadCliente) {
		this.edadCliente = edadCliente;
	}
	
	
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

	
	
	
}
