package himedia.myportal.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {
	@GetMapping({"/main", "/"})
	public String test() {
		return "/WEB-INF/views/home.jsp";
	}
		
}