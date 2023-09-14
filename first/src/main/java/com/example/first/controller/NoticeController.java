package com.example.first.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.first.dao.NoticeDAO;
import com.example.first.vo.NoticeVO;


@Controller @RequestMapping("/notice")
public class NoticeController {
	@Autowired private NoticeDAO dao;
	
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
	List<NoticeVO> list = dao.list();
	model.addAttribute("list", list);

		return "notice/list";
	}
}
