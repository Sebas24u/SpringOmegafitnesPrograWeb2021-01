package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="Sala")
public class Sala implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSala;
	
	@Column(name="nombreSala", nullable = false, length=30)
	private String nombreSala;
	@Column(name = "capacidadSala", nullable = false, length=30)
	private String capacidadSala;
	
	
	
	public Sala() {
		super();
	}

	public Sala(int idSala, String nombreSala, String capacidadSala) {
		super();
		this.idSala = idSala;
		this.nombreSala = nombreSala;
		this.capacidadSala = capacidadSala;
		
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public String getCapacidadSala() {
		return capacidadSala;
	}

	public void setCapacidadSala(String capacidadSala) {
		this.capacidadSala = capacidadSala;
	}


	
}
	
