package com.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.first.dao.UserDAO;
import com.example.first.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired private UserDAO dao;
	
	//회원가입 페이지
	@GetMapping("/join")
	public String join() {
		
		return "join";
	}
	
	//회원가입 처리
	@GetMapping("/register")
	public String register(UserVO vo) {
		dao.register(vo);
		return "redirect:/index";
	}
	
}
