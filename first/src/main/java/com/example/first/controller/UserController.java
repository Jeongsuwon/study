package com.example.first.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.first.dao.UserDAO;
import com.example.first.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired private UserDAO dao;
	
	@Autowired private static BCryptPasswordEncoder passwordEncoder; 

	
	//회원가입 페이지
	@GetMapping("/join")
	public String join() {
		
		return "join";
	}
	
	//회원가입 처리
	@PostMapping("/register")
	public String register(UserVO vo) {
		dao.register(vo);
		return "redirect:/";
	}
	//로그인 처리
	@PostMapping("/login")
	public String login(HttpSession session, String user_id, String user_pw) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("user_id", user_id);
		params.put("user_pw", user_pw);
		
		boolean match = false;
		
		UserVO vo = dao.login(params);
//		if (vo != null) { // 아이디가 일치하는 회원정보가 있고
//			match =  passwordEncoder.matches(user_pw, vo.getUser_pw()); // 비번일치여부 확인
//		}
//		if (match) {
//			session.setAttribute("loginInfo", vo);
////			return "redirect:/";
//			return "/board";
//		} else {
//			return "redirect:login"; // 로그인화면 다시 요청
//		}
		
		if (vo != null) {
		    // 데이터베이스에서 가져온 비밀번호와 입력한 비밀번호를 직접 비교
		    if (vo.getUser_pw().equals(user_pw)) {
		        // 비밀번호가 일치하는 경우
		        session.setAttribute("loginInfo", vo);
		        return "redirect:/notice/list";
		    }
		}
		// 비밀번호가 일치하지 않거나 사용자 정보가 없는 경우
		return "redirect:/";

	}
	
	//정보수정 페이지
	@GetMapping("/modify")
	public String modify(HttpSession session, Model model) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
		model.addAttribute("user", dao.info(vo.getUser_id()));
		return "modify";
	}
	
	//정보 수정시 비밀번호 작성 페이지
	@GetMapping("/modify_check")
	public String modify_check(){
		
		
		return "modify_check";
	}
	
	//비밀번호 확인 처리
	@PostMapping("/pw_check")
	public String pw_check(HttpSession session, Model model,String user_pw) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
		
		if(vo != null) {
			if(vo.getUser_pw().equals(user_pw)) {
				return "redirect:/modify";
			}else {
				 model.addAttribute("error", "비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}
		}
		return "modify_check";
	}
	
	
	//회원정보 페이지
	@GetMapping("/info")
	public String info(HttpSession session, Model model) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
		model.addAttribute("user", dao.info(vo.getUser_id()));
		return "info";
	}
	
	//회원정보 수정처리
	@PostMapping("/user_update")
	public String user_update(UserVO vo) {
		dao.update(vo);
		return "redirect:/";
	}
	
	
}
