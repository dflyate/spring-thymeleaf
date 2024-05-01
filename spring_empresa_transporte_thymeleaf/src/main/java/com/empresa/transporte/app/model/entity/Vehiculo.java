package com.empresa.transporte.app.model.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id
	@Column(name = "id_vehiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehiculo;
	@NotEmpty
	private String placa;
	@NotEmpty
	private String motor;
	@NotEmpty
	private String chasis;
	@Column(name = "fecha_matricula")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date fechaMatricula;
	@Column(name = "pasajeros_sentados")
	@NotNull
	private Integer pasajerosSentados;
	@Column(name = "pasajeros_pie")
	@NotNull
	private Integer pasajerosPie;
	@Column(name = "peso_seco")
	@NotNull
	private Double pesoSeco;
	@Column(name = "peso_bruto")
	@NotNull
	private Double pesoBruto;
	@NotNull
	private Integer puertas;
	@NotEmpty
	private String marca;
	@NotEmpty
	private String linea;
	
	@Transient
	private Boolean empSeleccionada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ConductorVehiculo> conductorVehiculos;
	
	
	
	public Vehiculo(Integer idVehiculo, String placa, String motor, String chasis, Date fechaMatricula,
			Integer pasajerosSentados, Integer pasajerosPie, Double pesoSeco, Double pesoBruto, Integer puertas,
			String marca, String linea) {
		this.idVehiculo = idVehiculo;
		this.placa = placa;
		this.motor = motor;
		this.chasis = chasis;
		this.fechaMatricula = fechaMatricula;
		this.pasajerosSentados = pasajerosSentados;
		this.pasajerosPie = pasajerosPie;
		this.pesoSeco = pesoSeco;
		this.pesoBruto = pesoBruto;
		this.puertas = puertas;
		this.marca = marca;
		this.linea = linea;
	}
	
	
	
	public Vehiculo() {
	}



	public Integer getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public Date getFechaMatricula() {
		return fechaMatricula;
	}
	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public Integer getPasajerosSentados() {
		return pasajerosSentados;
	}
	public void setPasajerosSentados(Integer pasajerosSentados) {
		this.pasajerosSentados = pasajerosSentados;
	}
	public Integer getPasajerosPie() {
		return pasajerosPie;
	}
	public void setPasajerosPie(Integer pasajerosPie) {
		this.pasajerosPie = pasajerosPie;
	}
	public Double getPesoSeco() {
		return pesoSeco;
	}
	public void setPesoSeco(Double pesoSeco) {
		this.pesoSeco = pesoSeco;
	}
	public Double getPesoBruto() {
		return pesoBruto;
	}
	public void setPesoBruto(Double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	public Integer getPuertas() {
		return puertas;
	}
	public void setPuertas(Integer puertas) {
		this.puertas = puertas;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	public List<ConductorVehiculo> getConductorVehiculos() {
		return conductorVehiculos;
	}



	public void setConductorVehiculos(List<ConductorVehiculo> conductorVehiculos) {
		this.conductorVehiculos = conductorVehiculos;
	}



	public Boolean getEmpSeleccionada() {
		return empSeleccionada;
	}



	public void setEmpSeleccionada(Boolean empSeleccionada) {
		this.empSeleccionada = empSeleccionada;
	}
	
	

}
