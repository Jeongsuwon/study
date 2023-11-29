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
	
	
	//공지사항 목록화면
	@GetMapping("/list")
	public String list(Model model, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
	List<NoticeVO> list = dao.list();
	model.addAttribute("list", list);

		return "notice/list";
	}
	
	//자유게시판 목록화면
	@GetMapping("/freedom")
	public String freedom(Model model, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
	List<NoticeVO> freedom = dao.freedom();
	model.addAttribute("freedom", freedom);

		return "notice/freedom";
	}
	
	//자유게시판 목록화면
	@GetMapping("/event")
	public String event(Model model, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
	List<NoticeVO> event = dao.event();
	model.addAttribute("event", event);

		return "notice/event";
	}
	
	//공지사항 추가화면 요청
	@GetMapping("/new")
	public String new_notice() {
		
		return "notice/new";
	}
	
	
	//공지사항 추가처리
	@PostMapping("/notice_insert")
	public String notice_insert(NoticeVO vo, HttpSession session) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
		dao.insert(vo);
		return "redirect:list";
	}
	
	//공지사항 정보화면 요청
	@GetMapping("/notice_info")
	public String notice_info(Integer id, Model model, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
		model.addAttribute("vo", dao.info(id));
		return "notice/info";
	}
	
	
	//공지사항 수정화면 요청
	@GetMapping("/modify")
	public String notice_modify(Model model, Integer id, HttpSession session, NoticeVO vo) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
	    vo.setUser_id(user.getUser_id());
	    System.out.println("ID 파라미터 값: " + id);
		model.addAttribute("vo", dao.info(id));
		return "notice/modify";
	}
	
	//공지사항 수정처리
	@PostMapping("/notice_update")
	public String notice_update(NoticeVO vo, HttpSession session, Integer id) {
		 UserVO user = (UserVO) session.getAttribute("loginInfo");
		 vo.setUser_id(user.getUser_id());
		 System.out.println("ID 파라미터 값:" + id);
		dao.update(vo);
		return "redirect:notice_info?id=" + vo.getId();
	}
	
	//공지사항 삭제처리
	@GetMapping("/notice_delete")
	public String notice_delete(NoticeVO vo, HttpSession session, Integer id) {
		UserVO user = (UserVO) session.getAttribute("loginInfo");
		 vo.setUser_id(user.getUser_id());
		 System.out.println("ID 파라미터 값:" + id);
		dao.delete(vo);
		return "redirect:list";
	}
	
}
