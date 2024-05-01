package com.empresa.transporte.app.model.service;

import java.util.*;

import com.empresa.transporte.app.model.entity.Empresa;

public interface EmpresaService {

	public List<Empresa> listarEmpresa();
	public Empresa buscarPorId(Integer id);
	public void guardar(Empresa empresa);
	public void eliminar(Integer id);
}
