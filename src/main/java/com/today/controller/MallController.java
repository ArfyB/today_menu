package com.today.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    	m.addAttribute("list",svc.list());
        return "thymeleaf/mall/MallMain";
    }
    
    @GetMapping("/detail/{ca}")
    @ResponseBody
    public String MallDetail(@PathVariable("ca")String ca)
    {
    	return ca;
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