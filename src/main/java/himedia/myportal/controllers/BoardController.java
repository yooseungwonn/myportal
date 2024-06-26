package himedia.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.repositories.vo.BoardVo;
import himedia.myportal.repositories.vo.UserVo;
import himedia.myportal.services.BoardService;
import jakarta.servlet.http.HttpSession;

// 게시판은 사용자 기반 서비스
// - 목록은 로그인 상관 없이 접근 가능
// - 조회, 작성, 수정 등을 로그인해야 사용가능
@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping({"", "/", "/list"})
	public String list(Model model) {
		List<BoardVo> list = boardService.getList();
		model.addAttribute("list", list);
		System.out.println(list);
		return "board/list";
	}
	
	@GetMapping("/{no}")
	public String view(@PathVariable("no") Long no, Model model, HttpSession session) {
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser == null) {
			// 홈 화면으로 리다이렉트
			return "redirect:/";
		}
		System.out.println("no:" + no);
		BoardVo boardVo = boardService.getContent(no);
		System.out.println("vo:" + boardVo);
		model.addAttribute("vo", boardVo);
		return "board/view";
	}
}
