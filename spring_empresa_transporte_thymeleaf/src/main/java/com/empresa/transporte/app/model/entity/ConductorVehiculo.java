package com.empresa.transporte.app.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "conductor_vehiculo")
public class ConductorVehiculo {

	@Id
	@Column(name="id_conductor_vehiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idConductorVehiculo;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conductor")
	private Conductor conductor;

	public ConductorVehiculo() {
	}

	public Integer getIdConductorVehiculo() {
		return idConductorVehiculo;
	}

	public void setIdConductorVehiculo(Integer idConductorVehiculo) {
		this.idConductorVehiculo = idConductorVehiculo;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	
	
}
