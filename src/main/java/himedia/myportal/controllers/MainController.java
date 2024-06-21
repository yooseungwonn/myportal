package himedia.myportal.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import himedia.myportal.exceptions.MainControllerException;



@Controller
public class MainController {
	@GetMapping({"/main", "/"})
	public String test() {
//		return "/WEB-INF/views/home.jsp";
		return "home";
	}
	
	@GetMapping("/except")
	@ResponseBody
	public String raiseExcept() {
		// RuntimeException -> 좀 더 구체적인 예외로 전환한 이후 throw 해준다
//		throw new RuntimeException("force Exception");
		throw new MainControllerException("메인 컨트롤러에서 예외가 발생했습니다");
	}
}
	
//	@ExceptionHandler(MainControllerException.class)
//	public String handleControllerExcept(MainControllerException e, Model model) {
//		model.addAttribute("name", e.getClass().getSimpleName());
//		model.addAttribute("message", e.getMessage());
//		
//		return "errors/exception";
//	}
//}
	
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public String handlerControllerException(RuntimeException e) {
//		return "Exception: " + e.getMessage();		
//	}
//}