package kr.co.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ex.board.BoardDAO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDAO service;

	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", service.list());
	}
}
