package com.empresa.transporte.app.model.service;

import java.util.List;

import com.empresa.transporte.app.model.entity.Vehiculo;

public interface VehiculoService {

	public List<Vehiculo> listarVehiculos();
	public Vehiculo buscarPorId(Integer id);
	public List<Vehiculo> buscarPorIdEmpresa(Integer idEmpresa);
	public List<Vehiculo> buscarPorIdEmpresaActualizacion(Integer idEmpresa);
	public void guardar(Vehiculo empresa);
	public void eliminar(Integer id);
}
