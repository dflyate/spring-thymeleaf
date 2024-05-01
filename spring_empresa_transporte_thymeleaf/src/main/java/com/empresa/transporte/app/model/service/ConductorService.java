package com.empresa.transporte.app.model.service;

import java.util.List;

import com.empresa.transporte.app.model.entity.Conductor;
import com.empresa.transporte.app.model.entity.Empresa;

public interface ConductorService {

	public List<Conductor> listarConductores();
	public Conductor buscarPorId(Integer id);
	public void guardar(Conductor empresa);
	public void eliminar(Integer id);
}
