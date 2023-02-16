package com.luv2code.springsecurity.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	//add mapping for leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	//add request mapping for systems

	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}
}
