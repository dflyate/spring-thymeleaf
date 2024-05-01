package com.empresa.transporte.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.transporte.app.model.entity.Empresa;
import com.empresa.transporte.app.model.entity.Vehiculo;
import com.empresa.transporte.app.model.service.EmpresaService;
import com.empresa.transporte.app.model.service.VehiculoService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/empresas")
@SessionAttributes({"empresa","vehiculos"})
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	private final String URL = "http://localhost:8090/";

	@GetMapping({"","/"})
	public String listarEmpresas(Model model, HttpServletRequest request){
		String referer = request.getHeader("referer");
		System.out.println(referer);
		boolean visibleOpciones = referer.length() > URL.length()  && !referer.contains("empresa") ? false : true;
		boolean visibleItems = referer.length() > URL.length() && !referer.contains("empresa") ? true : false;
		/*if(referer.contains("detalleVehiculos")) {
			visibleItems = true;
			visibleOpciones = false;
		}*/
		List<Empresa> empresas = empresaService.listarEmpresa();
		model.addAttribute("empresas",empresas);
		model.addAttribute("visibleOpciones",visibleOpciones);
		model.addAttribute("visibleItems",visibleItems);
		return "empresa/listado";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		Empresa empresa = new Empresa();
		model.addAttribute("empresa",empresa);
		return "empresa/form";
	}
	
	@RequestMapping(value = "/detalleVehiculos/{id}")
	public String obtenerDetalleVehiculos(@PathVariable Integer id, Model model, HttpServletRequest request) {
		String referer = request.getHeader("referer");
		System.out.println(referer);
		List<Vehiculo> vehiculos = vehiculoService.buscarPorIdEmpresa(id);
		for(Vehiculo vehiculo: vehiculos) {
			if(vehiculo.getEmpresa() != null && vehiculo.getEmpresa().getIdEmpresa() == id) {
				vehiculo.setEmpSeleccionada(true);
			}
		}
		model.addAttribute("vehiculos",vehiculos);
		return "vehiculo/detalleListadoLectura";
	}
	
	@RequestMapping(value = "/detalleVehiculosActualizar/{id}")
	public String actualizarVehiculos(@PathVariable Integer id,  Model model,HttpServletRequest request) {
		String referer = request.getHeader("referer");
		String [] urlPartes = referer.split("/");
		Integer idEmpresa = Integer.valueOf(urlPartes[urlPartes.length-1]);
		System.out.println(idEmpresa);
		Vehiculo vehiculo = vehiculoService.buscarPorId(id);
		if(vehiculo.getEmpresa() == null || vehiculo.getEmpresa().getIdEmpresa() != idEmpresa) {
			vehiculo.setEmpresa(new Empresa(idEmpresa));
		}else {
			vehiculo.setEmpresa(null);
		}
		vehiculoService.guardar(vehiculo);
		return "redirect:"+referer;
	}
	
	@RequestMapping(value = "/detalleVehiculosActualizacion/{id}")
	public String obtenerDetalleVehiculosActualizacion(@PathVariable Integer id, Model model, HttpServletRequest request) {
		String referer = request.getHeader("referer");
		System.out.println(referer);
		List<Vehiculo> vehiculos = vehiculoService.buscarPorIdEmpresaActualizacion(id);
		for(Vehiculo vehiculo: vehiculos) {
			if(vehiculo.getEmpresa() != null && vehiculo.getEmpresa().getIdEmpresa() == id) {
				vehiculo.setEmpSeleccionada(true);
			}
		}
		model.addAttribute("vehiculos",vehiculos);
		return "vehiculo/detalleListadoActualizacion";
	}
	
	@PostMapping(value = "/form")
	public String guardar(@Valid Empresa empresa,BindingResult result, Model model, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			return "empresa/form";
		}
		System.out.println(empresa.getIdEmpresa());
		empresaService.guardar(empresa);
		return "redirect:/empresas";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable Integer id) {
		if(id > 0) {
			Empresa empresa = empresaService.buscarPorId(id);
			empresaService.eliminar(id);
		}
		return "redirect:/empresas";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable Integer id, Model model) {
		Empresa empresa = null;
		if(id > 0) {
			empresa = empresaService.buscarPorId(id);
			if(empresa == null) {
				return "redirect:/empresas";
			}
		}else {
			return "redirect:/empresas";
		}
		
		empresa.setIdEmpresa(id);
		System.out.println(empresa.getIdEmpresa());
		model.addAttribute("empresa",empresa);
		return "empresa/form";
	}
}
