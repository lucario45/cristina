package br.com.alura.horas.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class HoraLancada {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	@Pattern(regexp="\\d{2}:\\d{2}")
	private String horaInicial;
	
	@Pattern(regexp="\\d{2}:\\d{2}")
	private String horaFinal;
	
	private String comentario;
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@ManyToOne
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Double getDuracao (){
		try {			
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			Date fim = format.parse(horaFinal);
			Date inicio = format.parse(horaInicial);
			long millis = fim.getTime() -inicio.getTime();
			return ((double) millis/(60*60*1000));
		} catch (ParseException e) {
			return 0.0;
		}
		
	}
	
}
