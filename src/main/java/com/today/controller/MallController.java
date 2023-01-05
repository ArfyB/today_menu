package com.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.today.service.MallService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/mall")
public class MallController
{
	@Autowired
	private MallService svc;
	
    @RequestMapping("/main")
    public String main(Model m) 
    {
    	//m.addAttribute("name","dlfma");
        return "thymeleaf/mall/MallMain";
    }
    
    /*
    @PostMapping("/login")
    @ResponseBody
    public Map<String, Object> userid(String uid, HttpSession session)
    {
    	Map<String, Object> map = new HashMap<>();
    	session.setAttribute("uid", uid);
    	
    	log.info((String)session.getAttribute("로그 : uid	"));
    	
    	map.put("uid", uid);
    	
    	return map;
    }
    
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Locale locale, Model model) {
        return "thymeleaf/chat";
    }
    */
}