package com.empresa.transporte.app.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.transporte.app.model.entity.Conductor;

@Repository
public interface IConductorDao extends CrudRepository<Conductor	, Integer>{

}
