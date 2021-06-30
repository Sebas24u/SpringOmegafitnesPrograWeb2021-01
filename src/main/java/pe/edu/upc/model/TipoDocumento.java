package pe.edu.upc.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="TipoDocumento")
public class TipoDocumento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoDocumento;
	
	@Column(name="nombreTipoDocumento", nullable = false, length=30)
	private String nombreTipoDocumento;
	

	
	public TipoDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TipoDocumento(int idTipoDocumento, String nombreTipoDocumento) {
		super();
		this.idTipoDocumento = idTipoDocumento;
		this.nombreTipoDocumento = nombreTipoDocumento;
	}



	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}



	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}



	public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}


	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}
	
	
	
	
}
