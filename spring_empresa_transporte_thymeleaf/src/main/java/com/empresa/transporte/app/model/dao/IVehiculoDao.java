package com.empresa.transporte.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.transporte.app.model.entity.Empresa;
import com.empresa.transporte.app.model.entity.Vehiculo;

@Repository
public interface IVehiculoDao extends CrudRepository<Vehiculo, Integer>{

	@Query("SELECT t FROM Vehiculo t WHERE t.empresa.idEmpresa = ?1")
	public List<Vehiculo> findByEmpresa(Integer idEmpresa);
	
	@Query("SELECT t FROM Vehiculo t WHERE t.empresa.idEmpresa = ?1 OR t.empresa.idEmpresa  = null")
	public List<Vehiculo> findByEmpresaActualizacion(Integer idEmpresa);
}
