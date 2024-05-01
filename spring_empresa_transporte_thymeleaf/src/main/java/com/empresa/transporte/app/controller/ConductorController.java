package com.empresa.transporte.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.transporte.app.model.entity.Conductor;
import com.empresa.transporte.app.model.entity.Empresa;
import com.empresa.transporte.app.model.entity.Vehiculo;
import com.empresa.transporte.app.model.service.ConductorService;
import com.empresa.transporte.app.model.service.ConductorVehiculoService;
import com.empresa.transporte.app.model.service.VehiculoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/conductores")
@SessionAttributes("conductor")
public class ConductorController {
	
	@Autowired
	private ConductorService conductorService;
	
	@Autowired
	private ConductorVehiculoService conductorVehiculoService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping()
	public String listarConductores(Model model, HttpServletRequest request) {
		List<Conductor> conductores = conductorService.listarConductores();
		model.addAttribute("conductores",conductores);
		model.addAttribute("visibleItems",true);
		return "conductor/listado";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Conductor conductor = new Conductor();
		model.addAttribute("conductor",conductor);
		return "conductor/form";
	}
	
	@RequestMapping(value = "/detalleVehiculos/{id}")
	public String obtenerDetalleVehiculos(@PathVariable Integer id, Model model, HttpServletRequest request) {
		List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
		model.addAttribute("vehiculos",vehiculos);
		return "vehiculo/detalleListadoVehiculos";
	}
	
	@PostMapping(value = "/form")
	public String guardar(@Valid Conductor conductor,BindingResult result, Model model, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			return "conductor/form";
		}
		System.out.println(conductor.getIdConductor());
		conductorService.guardar(conductor);
		return "redirect:/conductores";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		if(id > 0) {
			Conductor conductor = conductorService.buscarPorId(id);
			conductorService.eliminar(id);
		}
		return "redirect:/conductores";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Conductor conductor = null;
		if(id > 0) {
			conductor = conductorService.buscarPorId(id);
			if(conductor == null) {
				return "redirect:/conductores";
			}
		}else {
			return "redirect:/conductores";
		}
		model.addAttribute("conductor",conductor);
		return "conductor/form";
	}

}
