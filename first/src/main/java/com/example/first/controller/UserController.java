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
	

	//로그인 페이지
	@GetMapping("/sign_in")
	public String sign_in(){
		return "sign_in";
	}
	
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

	    UserVO vo = dao.login(params);

	    if (vo != null) {
	        // 데이터베이스에서 가져온 비밀번호와 입력한 비밀번호를 직접 비교
	        if (vo.getUser_pw().equals(user_pw)) {
	            // 비밀번호가 일치하는 경우
	            // 비밀번호를 제외한 사용자 정보만을 세션에 저장
	            vo.setUser_pw(null);
	            session.setAttribute("loginInfo", vo);
	            return "redirect:/";
	        }
	    }

	    // 비밀번호가 일치하지 않거나 사용자 정보가 없는 경우
	    return "redirect:/";
	}
	
	//로그아웃 처리
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		
		return "redirect:/";
	}
	
	//정보수정 페이지
	@GetMapping("/modify")
	public String modify(HttpSession session, Model model) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
		model.addAttribute("user", dao.info(vo.getUser_id()));
		return "modify";
	}
	
	//정보수정 시 비밀번호 작성 페이지
	@GetMapping("/modify_check")
	public String modify_check(){
		
		
		return "modify_check";
	}
	
	
	//회원탈퇴 시 비밀번호 작성 페이지
	@GetMapping("/delete_check")
	public String delete_check(){
		
		
		return "delete_check";
	}
	
	//비밀번호 확인 처리
	@PostMapping("/pw_delete_check")
	public String modify_pw_check(HttpSession session, Model model,String user_pw) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
		
		if(vo != null) {
			if(vo.getUser_pw().equals(user_pw)) {
				
				return "redirect:/";
			}else {
				 model.addAttribute("error", "비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}
		}
		return "delete_check";
	}
	
	//비밀번호 확인 처리
	@PostMapping("/pw_modify_check")
	public String delete_pw_check(HttpSession session, Model model,String user_pw) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
		
		if(vo != null) {
			if(vo.getUser_pw().equals(user_pw)) {
				return "redirect:/modify";
			}else {
				 model.addAttribute("error", "비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			}
		}
		return "pw_modify_check";
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
	
	//회원탈퇴 처리
	@PostMapping("/user_delete")
	public String user_delete(HttpSession session) {
		UserVO vo = (UserVO) session.getAttribute("loginInfo");
	    if (vo != null) {
	        dao.delete(vo);
	        session.removeAttribute("loginInfo");
	    }
		
		return "redirect:/";
	}
	
	//게시판 페이지
	@GetMapping("/notice")
	public String noticeList() {
        return "redirect:/notice/list";
	}
	
	
}
