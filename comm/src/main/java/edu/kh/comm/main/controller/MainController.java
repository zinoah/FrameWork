package edu.kh.comm.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //컨트롤러 bean 등록
public class MainController {
	
	@RequestMapping("/main")
	public String mainForward() {
		
		return "common/main"; //DispatcherServlet이 받을거다! -> View Resolver
	}
}
