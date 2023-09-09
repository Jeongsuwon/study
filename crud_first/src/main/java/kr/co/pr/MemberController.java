package kr.co.pr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberDAO;
import member.MemberVO;

@Controller @RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberDAO dao;
	
	@RequestMapping("/join")
	public String join() {
		
		return "/member/join";
	}
	
	@RequestMapping("/register")
	public String register(MemberVO vo) {
		dao.register(vo);
		return "redirect:login";
	}

}
