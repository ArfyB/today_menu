package com.today.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.today.service.MallService;
import com.today.vo.Category;
import com.today.vo.Product;

import jakarta.servlet.http.HttpServletRequest;
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
       m.addAttribute("list",svc.CategoryList());
        return "thymeleaf/mall/MallMain";
    }
    /*
    @GetMapping("/detail/{ca}")
    @ResponseBody
    public String MallDetail(@PathVariable("ca")String ca)
    {
       return ca;
    }
    */
    @RequestMapping("/clist/{ca}")
    public String CateList(Model m,@PathVariable("ca") String ca)
    {
       m.addAttribute("clist",svc.clist());
    m.addAttribute("CdList",svc.CdList(ca));
    m.addAttribute("ProductD",svc.ProductD(ca));
    m.addAttribute("getN",svc.getN(ca));
       return "thymeleaf/mall/clist";
    }
    
    
    @RequestMapping("/add")
    public String productadd(Model m) 
    {
        return "thymeleaf/mall/ProductAdd";
    }
    
    @PostMapping("/add")
    @ResponseBody
    public Map<String,Object> add(Product pro)
    {
       Map<String,Object> map = new HashMap<>();
       boolean added = svc.ProductAdd(pro);
       map.put("added", added);
       return map;
    }
    
    @PostMapping("/upload")
    @ResponseBody
      public Map<String, Object> upload(@RequestParam("files")MultipartFile[] mfiles,
                        HttpServletRequest request,
                        Product pro) 
      {
       Map<String, Object> map = new HashMap<>();
       
       map.put("mfiles", mfiles);
       map.put("request", request);
       map.put("product", pro);
       
       Map<String, Object> added = new HashMap<>();
       added.put("added", svc.addPA(map));
       
       return added;
      }
    
    @GetMapping("/detail") // 리스트에서 제품클릭시에 해당 제품의 num 보내줄것 = 제품고유번호 
    public String getProduct(Product pro, Model m)
    {
       m.addAttribute("product",svc.getProduct(pro));
       System.out.println("가져온 정보"+svc.getProduct(pro));
       
       return "thymeleaf/mall/ProductDetail";
    }
}