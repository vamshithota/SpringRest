package com.springsecurity.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/springsecurity")
@Controller
public class Democontroller {

	@RequestMapping("/")
	public String getHome() {
		return "home";
	}
	
}
