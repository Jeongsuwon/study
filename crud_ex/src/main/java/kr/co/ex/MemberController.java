package kr.co.ex;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	/*
	 * @Autowired private MemberDAO service;
	 * 
	 * @Autowired private BCryptPasswordEncoder pwEncoder;
	 */

	@RequestMapping("/join")
	public String join(HttpSession session) {
		session.setAttribute("category", "join");
		return "member/join";
	}

}
