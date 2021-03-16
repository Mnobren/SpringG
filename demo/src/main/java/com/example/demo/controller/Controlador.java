package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/hello")
public class Controlador {
	@GetMapping
	public String hello()
	{
		return "Atenção Aos Detalhes !";
	}
}