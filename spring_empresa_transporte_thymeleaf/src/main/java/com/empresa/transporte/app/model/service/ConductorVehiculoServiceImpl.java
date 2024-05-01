package com.empresa.transporte.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.transporte.app.model.dao.IConductorVehiculoDao;
import com.empresa.transporte.app.model.entity.ConductorVehiculo;

@Service
public class ConductorVehiculoServiceImpl implements ConductorVehiculoService{
	
	@Autowired
	private IConductorVehiculoDao conductorVehiculoDao;

	@Override
	public List<ConductorVehiculo> listarConductores() {
		// TODO Auto-generated method stub
		return (List<ConductorVehiculo>) conductorVehiculoDao.findAll();
	}

	@Override
	public ConductorVehiculo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return conductorVehiculoDao.findById(id).orElse(null);
	}

	@Override
	public void guardar(ConductorVehiculo conductor) {
		conductorVehiculoDao.save(conductor);
		
	}

	@Override
	public void eliminar(Integer id) {
		conductorVehiculoDao.deleteById(id);
		
	}

}
