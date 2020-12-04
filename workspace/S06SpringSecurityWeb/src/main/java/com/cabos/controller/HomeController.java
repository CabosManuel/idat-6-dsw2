package com.cabos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value= {"/","/index"},method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@GetMapping("/estudiante")
	public String estudiante() {
		return "estudiante";
	}
	
	@GetMapping("/docente")
	public String docente() {
		return "docente";
	}
	
	@RequestMapping(value = "/access_denied",method = RequestMethod.GET)
	public String access_denied() {
		return "access_denied";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
