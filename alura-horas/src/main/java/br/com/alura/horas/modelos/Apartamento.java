package br.com.alura.horas.modelos;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public class Apartamento implements Serializable {
	/* 
	 * Para um apartamento, devem-se cadastrar: seu numero de porta, a quantidade de quartos, o tipo de ocupado 
	 * (proprietario, inquilino ou vazio), o nome 
		do proprietario e o telefone do proprietario. Um proprietario pode ter mais de um apartamento no predio.
	 * */
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private int numeroPorta;
	
	@NotEmpty
	private int quantQuartos;
	
	@NotEmpty
	private String tipoOcupacao;

	private Propietario propietario;
	
	private Inquilino inquilino;
	
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public Apartamento(int numeroPorta, int quantQuartos, Propietario propietario) {
		this.numeroPorta = numeroPorta;
		this.quantQuartos = quantQuartos;
		this.propietario = propietario;
	}

	public int getNumeroPorta() {
		return numeroPorta;
	}

	public void setNumeroPorta(int numeroPorta) {
		this.numeroPorta = numeroPorta;
	}

	public int getQuantQuartos() {
		return quantQuartos;
	}

	public void setQuantQuartos(int quantQuartos) {
		this.quantQuartos = quantQuartos;
	}

	public String getTipoOcupacao() {
		return tipoOcupacao;
	}

	public void setTipoOcupacao(String tipoOcupacao) {
		this.tipoOcupacao = tipoOcupacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

}
