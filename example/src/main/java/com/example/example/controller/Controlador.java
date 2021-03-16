package com.example.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/obj")
public class Controlador {
	@GetMapping
	public String obj()
	{
		return "Meu objetivo é dominar o Spring.";
	}
}