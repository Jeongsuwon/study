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
import com.example.first.vo.UserVO;


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
	public String notice_insert(NoticeVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
		dao.insert(vo);
		return "redirect:list";
	}
	
	@GetMapping("/notice_info")
	public String notice_info(Integer id, Model model, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
		model.addAttribute("vo", dao.info(id));
		return "notice/info";
	}
	
	@GetMapping("/modify")
	public String notice_modify(Model model, Integer id, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
	    System.out.println("ID 파라미터 값: " + id);
		model.addAttribute("vo", dao.info(id));
		return "notice/modify";
	}
	
	@GetMapping("/delete")
	public String notice_delete() {
		
		return "notice/delete";
	}
	
}
