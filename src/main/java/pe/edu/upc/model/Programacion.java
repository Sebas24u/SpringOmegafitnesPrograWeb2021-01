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
@Table(name="Programacion")
public class Programacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProgramacion;
	

	@Column(name = "horaInicial", nullable = false, length=50)
	private String horaInicial;

	@Column(name = "horaFinal", nullable = false, length=50)
	private String horaFinal;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaProgramacion", nullable=false,length = 50)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaProgramacion;
	
	
	@ManyToOne
	@JoinColumn(name="idActividad", nullable=false)
	private Actividad actividad;
	
	public Programacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programacion(int idProgramacion, String horaInicial, String horaFinal, Date fechaProgramacion,
			Actividad actividad) {
		super();
		this.idProgramacion = idProgramacion;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.fechaProgramacion = fechaProgramacion;
		this.actividad = actividad;
	}

	public int getIdProgramacion() {
		return idProgramacion;
	}

	public void setIdProgramacion(int idProgramacion) {
		this.idProgramacion = idProgramacion;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Date getFechaProgramacion() {
		return fechaProgramacion;
	}

	public void setFechaProgramacion(Date fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	
	
}
