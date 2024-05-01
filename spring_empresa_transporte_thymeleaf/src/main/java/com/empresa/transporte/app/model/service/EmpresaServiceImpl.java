package com.empresa.transporte.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.transporte.app.model.dao.IEmpresaDao;
import com.empresa.transporte.app.model.entity.Empresa;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	@Autowired
	private IEmpresaDao empresaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empresa> listarEmpresa() {
		// TODO Auto-generated method stub
		return (List<Empresa>) empresaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Empresa empresa) {
		empresaDao.save(empresa);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		empresaDao.deleteById(id);
	}

}
