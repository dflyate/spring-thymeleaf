package com.empresa.transporte.app.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.transporte.app.model.entity.Empresa;

@Repository
public interface IEmpresaDao extends CrudRepository<Empresa, Integer>{

}
