package com.example.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.dao.NoticeDAO;
import com.example.first.vo.NoticeVO;


@Controller @RequestMapping("/notice")
public class NoticeController {
	@Autowired private NoticeDAO dao;
	
	@GetMapping("/list")
	public String list(Model model, HttpSession session) {
	List<NoticeVO> list = dao.list();
	model.addAttribute("list", list);

		return "notice/list";
	}
	
	@GetMapping("/new")
	public String new_notice() {
		
		return "notice/new";
	}
	
	@PostMapping("/notice_insert")
	public String notice_insert(NoticeVO vo) {
		dao.insert(vo);
		return "redirect:notice/list";
	}
}
