package com.empresa.transporte.app.model.entity;

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

import java.util.*;
@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private Integer idEmpresa;
	@Column(name = "tipo_documento")
	@NotEmpty
	private String tipoDocumento;
	@Column(name = "numero_documento")
	@NotEmpty
	private String numeroDocumento;
	@Column(name = "nombre_completo")
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
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehiculo> vehiculos;
	
	public Empresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public Empresa() {
	}
	public Empresa(Integer idEmpresa, String tipoDocumento, String numeroDocumento, String nombreCompleto,
			String direccion, String ciudad, String departamento, String pais, String telefono) {
		this.idEmpresa = idEmpresa;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.pais = pais;
		this.telefono = telefono;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
}
