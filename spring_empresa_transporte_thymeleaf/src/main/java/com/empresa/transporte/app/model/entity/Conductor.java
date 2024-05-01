package com.empresa.transporte.app.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "conductor")
public class Conductor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_conductor")
	private Integer idConductor;
	@Column(name="tipo_identificacion")
	@NotEmpty
	private String tipoIdentificacion;
	@Column(name="numero_identificacion")
	@NotEmpty
	private String numeroIdentificacion;
	@Column(name="nombre_completo")
	@NotEmpty
	private String nombreCompleto;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String ciudad;
	@NotEmpty
	private String departamento;
	@NotEmpty
	private String pais;
	private String telefono;
	
	@OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ConductorVehiculo> conductorVehiculos;
	
	public Conductor() {
	}

	public Conductor(Integer idConductor, String tipoIdentificacion, String numeroIdentificacion, String nombreCompleto,
			String direccion, String ciudad, String departamento, String pais, String telefono) {
		this.idConductor = idConductor;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.pais = pais;
		this.telefono = telefono;
	}

	public Integer getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Integer idConductor) {
		this.idConductor = idConductor;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<ConductorVehiculo> getConductorVehiculos() {
		return conductorVehiculos;
	}

	public void setConductorVehiculos(List<ConductorVehiculo> conductorVehiculos) {
		this.conductorVehiculos = conductorVehiculos;
	}
	
	
}
