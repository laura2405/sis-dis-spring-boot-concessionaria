package br.com.unicuritiba.concessionaria.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.List;
import jakarta.persistence.ManyToMany;

@Entity
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "plataforma_id")
	private Plataforma plataforma;
	
	private String carroceria;
	
	private String cambio;
	
	private String motor;
	
	private String ano;

	@ManyToMany
    private List<Peca> pecas;

	public List<Peca> getPecas() {
    return pecas;
}

public void setPecas(List<Peca> pecas) {
    this.pecas = pecas;
}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	public List<Peca> getPecas() {
    return pecas;
}

public void setPecas(List<Peca> pecas) {
    this.pecas = pecas;
}
}
