package com.example.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String login() {
		
		return "index"; //templates 폴더의 login.html
	}
}
