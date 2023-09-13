package com.example.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	//회원가입 페이지
	@GetMapping("/join")
	public String join() {
		
		return "join";
	}
	
	//회원가입 처리
	@GetMapping("register")
	public String register() {
		
		return "redirect:/index";
	}
	
}
