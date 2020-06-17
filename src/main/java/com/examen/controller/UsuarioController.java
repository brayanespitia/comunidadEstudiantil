package com.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.model.dao.IUsuarioDao;
import com.examen.model.entity.Usuario;
import com.examen.model.service.UsuarioServiceImp;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServiceImp<Usuario> usuarioService;

	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("titulo", "Ingreso de usuarios al sitema");
		return "login";
	}

	@RequestMapping(value = "/registrate")
	public String login(Model model) {
		model.addAttribute("titulo", "registro de usuarios");
		return "registroUsuario";
	}

	@RequestMapping(value = "/activarCuenta")
	public String activarCuenta(Model model) {
		model.addAttribute("titulo", "Activar mi cuenta");
		return "activarCuenta";
	}

	@RequestMapping(value = "/ingresar", method = RequestMethod.POST)
	public String ingresar(@RequestParam(name = "username") String usuario,
			@RequestParam(name = "contrasenia") String contrasenia, Model model) {
		Usuario u = usuarioService.findByUsername(usuario);
		System.out.println(u);

		if (u != null) {
			if (u.getPassword()!=null && u.getPassword().equals(contrasenia)) {
				return "redirect:index";
			} else {
				model.addAttribute("respuesta", "usuario o contraseña incorrecto");
			}
		} else {
			model.addAttribute("respuesta", "el usuario no existe");
		}
		
		model.addAttribute("titulo", "Ingreso de usuarios al sitema");
		return "login";
	}

	@RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
	public String registrar(@RequestParam(name = "empresa") String empresa,
							@RequestParam(name = "usuario") String usuario, 
							@RequestParam(name = "email") String email,
							Model model) {	
				
		if (usuarioService.findByUsername(usuario)==null) {
			Usuario u = new Usuario();
			u.setUsername(usuario);
			u.setEmail(email);
			u.setEmpresa(empresa);
			usuarioService.save(u);
			return "redirect:activarCuenta";
		}		
		model.addAttribute("titulo", "registro de usuarios");
		model.addAttribute("respuesta","El nombre de usuario "+ usuario
							+" no se encuentra disponible");
		return "registroUsuario";
	}
	
	@RequestMapping(value = "/confirmarCuenta", method = RequestMethod.POST)
	public String activar(@RequestParam(name = "contrasenia") String contrasenia,
							@RequestParam(name = "usuario") String usuario, 
							@RequestParam(name = "contrasenia2") String contrasenia2,
							Model model ) {		
		Usuario u = usuarioService.findByUsername(usuario);
		if(u!=null) {
			if(contrasenia==contrasenia2) {
				u.setPassword(contrasenia);
				usuarioService.save(u);
				return "redirect:/";
			}else {
				model.addAttribute("respuesta","Las contraseñas no coinciden");
				return "activarCuenta";
			}
		}
		model.addAttribute("respuesta","El usuario "+usuario+" no existe");		
		return null;
	}

}
