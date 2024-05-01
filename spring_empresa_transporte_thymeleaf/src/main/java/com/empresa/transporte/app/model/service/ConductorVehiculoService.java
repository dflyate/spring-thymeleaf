package com.empresa.transporte.app.model.service;

import java.util.List;

import com.empresa.transporte.app.model.entity.ConductorVehiculo;


public interface ConductorVehiculoService {
	public List<ConductorVehiculo> listarConductores();
	public ConductorVehiculo buscarPorId(Integer id);
	public void guardar(ConductorVehiculo empresa);
	public void eliminar(Integer id);
}
