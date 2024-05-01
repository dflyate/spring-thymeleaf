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
import com.empresa.transporte.app.model.entity.Vehiculo;
import com.empresa.transporte.app.model.service.VehiculoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/vehiculos")
@SessionAttributes("vehiculo")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
	@GetMapping()
	public String listarVehiculos(Model model, HttpServletRequest request) {
		boolean visibleItems = true;
		List<Vehiculo> vehiculos = vehiculoService.listarVehiculos();
		model.addAttribute("vehiculos",vehiculos);
		model.addAttribute("visibleItems",visibleItems);
		return "vehiculo/listado";
	}
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Vehiculo vehiculo = new Vehiculo();
		model.addAttribute("vehiculo",vehiculo);
		return "vehiculo/form";
	}
	
	@PostMapping(value = "/form")
	public String guardar(@Valid Vehiculo vehiculo,BindingResult result, Model model, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			return "vehiculo/form";
		}
		vehiculoService.guardar(vehiculo);
		return "redirect:/vehiculos";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		if(id > 0) {
			Vehiculo vehiculo = vehiculoService.buscarPorId(id);
			vehiculoService.eliminar(id);
		}
		return "redirect:/vehiculos";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Vehiculo vehiculo = null;
		if(id > 0) {
			vehiculo = vehiculoService.buscarPorId(id);
			if(vehiculo == null) {
				return "redirect:/vehiculos";
			}
		}else {
			return "redirect:/vehiculos";
		}
		
		vehiculo.setIdVehiculo(id);
		System.out.println(vehiculo.getIdVehiculo());
		model.addAttribute("vehiculo",vehiculo);
		return "vehiculo/form";
	}
}
