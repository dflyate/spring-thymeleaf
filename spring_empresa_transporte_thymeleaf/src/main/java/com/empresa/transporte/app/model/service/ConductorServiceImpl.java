package com.empresa.transporte.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.transporte.app.model.dao.IConductorDao;
import com.empresa.transporte.app.model.entity.Conductor;
import com.empresa.transporte.app.model.entity.Empresa;

@Service
public class ConductorServiceImpl implements ConductorService{
	
	@Autowired
	private IConductorDao conductorDao;

	@Override
	public List<Conductor> listarConductores() {
		// TODO Auto-generated method stub
		return (List<Conductor>) conductorDao.findAll();
	}
	
	@Override
	@Transactional
	public void guardar(Conductor conductor) {
		conductorDao.save(conductor);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Conductor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return conductorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		conductorDao.deleteById(id);
	}

}
