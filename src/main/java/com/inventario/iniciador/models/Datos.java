package com.inventario.iniciador.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "Datos")
public class Datos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@Column(name="fechaRegsitro", updatable = false)
	private LocalDateTime fechaRegistro;
	
	@Column(name="nivelContaminación")
	private Integer Contaminación;
	
	@Column(name="latitud")
	private Double latitud;
	
	@Column(name="longitud")
	private Double longitud;
	
	@ManyToOne
    @JoinColumn(name = "sensor_id")
	private Sensores sensor;
	
	public Datos() {
		
	}

	public Datos(int id, LocalDateTime fechaRegistro, Integer contaminación, Double latitud, Double longitud, Sensores sensor) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
		Contaminación = contaminación;
		this.latitud = latitud;
		this.longitud = longitud;
		this.sensor = sensor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getContaminación() {
		return Contaminación;
	}

	public void setContaminación(Integer contaminación) {
		Contaminación = contaminación;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Sensores getSensor() {
		return sensor;
	}

	public void setSensor(Sensores sensor) {
		this.sensor = sensor;
	}
	
	
}
