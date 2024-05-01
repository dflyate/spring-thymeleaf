package com.empresa.transporte.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.transporte.app.model.dao.IVehiculoDao;
import com.empresa.transporte.app.model.entity.Empresa;
import com.empresa.transporte.app.model.entity.Vehiculo;

@Service
public class VehiculoServiceImpl implements VehiculoService{
	
	@Autowired
	private IVehiculoDao vehiculoDao;

	@Override
	public List<Vehiculo> listarVehiculos() {
		// TODO Auto-generated method stub
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Vehiculo vehiculo) {
		vehiculoDao.save(vehiculo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Vehiculo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return vehiculoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		vehiculoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> buscarPorIdEmpresa(Integer idEmpresa) {
		// TODO Auto-generated method stub
		return vehiculoDao.findByEmpresa(idEmpresa);
	}

	@Override
	public List<Vehiculo> buscarPorIdEmpresaActualizacion(Integer idEmpresa) {
		// TODO Auto-generated method stub
		return vehiculoDao.findByEmpresaActualizacion(idEmpresa);
	}
}
