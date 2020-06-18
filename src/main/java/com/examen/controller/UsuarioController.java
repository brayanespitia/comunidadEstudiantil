package com.examen.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.model.entity.Rol;
import com.examen.model.entity.Usuario;
import com.examen.model.service.JpaUserDetailsService;
import com.examen.model.service.RolServiceImp;
import com.examen.model.service.UsuarioServiceImp;


@Controller
public class UsuarioController {
	
	@Autowired
	private RolServiceImp<Rol> rolService;

	@Autowired
	private UsuarioServiceImp<Usuario> usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


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
	
	
	@RequestMapping(value = "/login")
	public String ingresar(Model model, Principal principal) {

		if (principal != null) {
			return "redirect:index";
		}
		
		model.addAttribute("titulo", "Ingreso de usuarios al sistema");
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
			System.out.println("save");
			return "redirect:activarCuenta";
		}		
		model.addAttribute("titulo", "registro de usuarios");
		model.addAttribute("respuesta","El nombre de usuario "+ usuario
							+" no se encuentra disponible");
		return "registroUsuario";
	}
	
	@RequestMapping(value = "/confirmarCuenta")
	public String activar(@RequestParam(name = "contrasenia") String contrasenia,
							@RequestParam(name = "usuario") String usuario, 
							@RequestParam(name = "contrasenia2") String contrasenia2,
							Model model ) {		
		Usuario u = usuarioService.findByUsername(usuario);		
		if(u!=null) {
			if(u.getPassword()==null) {
				model.addAttribute("respuesta","Esta cuenta ya ha sido activada anteriomente");
				return "activarCuenta";
			}
			if(contrasenia.equals(contrasenia2)) {
				String con=passwordEncoder.encode(contrasenia);
				u.setPassword(con);
				usuarioService.save(u);		
				return "redirect:/";
			}else {
				model.addAttribute("respuesta","Las contraseñas no coinciden");
				return "activarCuenta";
			}
		}
		model.addAttribute("respuesta","El usuario "+usuario+" no existe");		
		return "activarCuenta";
	}
	
	
	@RequestMapping(value = "/listaUsuarios")
	public String listar(Model model) {
		
		model.addAttribute("usuarios",usuarioService.findAll());
		return "usuarios";
	}
	
	@RequestMapping(value = "/editarUsuario/{idUsuario}")
	public String editarUsuario(@PathVariable(value = "idUsuario") Long id,Map<String, Object> model) {
		Usuario usuario = usuarioService.findOne((id));		
		model.put("usuario",usuario);
		return "editarUsuario";
	}

	@RequestMapping(value = "/guardarU")
	public String guardar(@Validated Usuario usuario,Model model) {		
		usuarioService.save(usuario);
		model.addAttribute("usuarios",usuarioService.findAll());
		return "redirect:listaUsuarios";
	}


}
