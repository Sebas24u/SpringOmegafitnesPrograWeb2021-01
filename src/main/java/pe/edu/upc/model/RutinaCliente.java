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
@Table(name="Rutinacliente")
public class RutinaCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRutinacliente;

	@ManyToOne
	@JoinColumn(name="idRutina",nullable=false)
	private Rutina rutina;
	
	@ManyToOne
	@JoinColumn(name="idCliente",nullable=false)
	private Cliente cliente;
	
	@Column(name="descripcionRutinaxCliente", length = 60, nullable=false)
	private String descripcionRutinaxCliente;


	public RutinaCliente() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RutinaCliente(int idRutinacliente, Rutina rutina, Cliente cliente, String descripcionRutinaxCliente) {
		super();
		this.idRutinacliente = idRutinacliente;
		this.rutina = rutina;
		this.cliente = cliente;
		this.descripcionRutinaxCliente = descripcionRutinaxCliente;
	}


	public int getIdRutinacliente() {
		return idRutinacliente;
	}


	public void setIdRutinacliente(int idRutinacliente) {
		this.idRutinacliente = idRutinacliente;
	}


	public Rutina getRutina() {
		return rutina;
	}


	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getDescripcionRutinaxCliente() {
		return descripcionRutinaxCliente;
	}


	public void setDescripcionRutinaxCliente(String descripcionRutinaxCliente) {
		this.descripcionRutinaxCliente = descripcionRutinaxCliente;
	}




	


	
	
	
}
