package com.inventario.iniciador.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Sensores")
public class Sensores{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="fechaRegistro")
	private Date fechaRegistro;
	
	@OneToMany
	private List<Datos> datos;

	public Sensores() {
		
	}

	public Sensores(int id, String modelo, String ciudad, Date fechaRegistro, List<Datos> datos) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.ciudad = ciudad;
		this.fechaRegistro = fechaRegistro;
		this.datos = datos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public List<Datos> getDatos() {
		return datos;
	}

	public void setDatos(List<Datos> datos) {
		this.datos = datos;
	}
	
	
	
}
