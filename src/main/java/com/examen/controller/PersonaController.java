package com.examen.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.model.entity.Ingreso;
import com.examen.model.entity.Persona;
import com.examen.model.service.IngresoServiceImp;
import com.examen.model.service.PersonaServiceImp;


@Controller
public class PersonaController {
	
	@Autowired
	private PersonaServiceImp<Persona> personaService;
	
	@Autowired
	private IngresoServiceImp<Ingreso> ingresoService;

	@RequestMapping(value = "/listaPersonas")
	public String lista(Model model) {
		model.addAttribute("titulo","Lista de personas");
		model.addAttribute("personas",personaService.findAll());
		System.out.println(personaService.findAll().size());
		return "personas";
	}
	
	@RequestMapping(value = "/listaIngresos/{id}")
	public String editarUsuario(@PathVariable(value = "id") Long id, Model model) {
		
		model.addAttribute("ingresos",ingreso(id));
		return "ingresos";
	}
	
	private ArrayList<Ingreso> ingreso(Long id){
		ArrayList<Ingreso> ingresos=new ArrayList<>();
		Persona p = personaService.findOne(id);
		for(Ingreso in:ingresoService.findAll()) {
			if(in.getPersona()==p) {
				ingresos.add(in);
			}
		}return ingresos;
	}
	
}
