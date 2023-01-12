package com.today.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rec")
public class RecommendController 
{
	@RequestMapping("/main")
	public String UserName(Model m) {
		m.addAttribute("username","김선유 개존예");
		return "thymeleaf/recommend/RecommendMain"; //templates/ RecommendMain.html 로 전송.
	}
}
