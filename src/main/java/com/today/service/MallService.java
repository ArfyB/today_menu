package com.today.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.today.mapper.CategoryMapper;
import com.today.vo.Category;
import com.today.vo.Product;
import com.today.vo.ProductPic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class MallService 
{
	@Autowired
	public CategoryMapper mapper;
	
	public List<Category> CategoryList()
	{
		List<Category> list = mapper.CategoryList();
		return list;
	}
	
	public List<Product> plist()
	{
		List<Product> plist = mapper.ProductList();
		return plist;
	}
	public List<Category> clist()
	{
		List<Category> clist = mapper.clist();
		return clist;
	}
	
	public boolean ProductAdd(Product pro)
	{
		boolean added = 0<mapper.ProductAdd(pro);
		return added;
	}
	
	public String addPA(Map map)
	{
		
		MultipartFile[] mfiles = (MultipartFile[]) map.get("mfiles");
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		Product pro = (Product) map.get("product");
		
		ServletContext context = request.getServletContext();
	      String savePath = context.getRealPath("/WEB-INF/files");
	      System.out.println(savePath);
	      //request.getSession().getServletContext().getRealPath("/");
	      List<ProductPic> list = new ArrayList<>();
	      
	      try 
	      {
	    	  int a = mapper.ProductAdd(pro);
	    	  
	    	  if(mfiles.length != 0)
	    	  {
	    		  
	         for(int i=0;i<mfiles.length;i++) 
	         {
	            mfiles[i].transferTo(
	            new File(savePath+"/"+mfiles[i].getOriginalFilename()));
	            
	            String fname = mfiles[i].getOriginalFilename();
	            
	            ProductPic pp = new ProductPic();
	            pp.setFname(mfiles[i].getOriginalFilename());
	            
	            list.add(pp);
	            /* MultipartFile 주요 메소드
	            String cType = mfiles[i].getContentType();
	            String pName = mfiles[i].getName();
	            Resource res = mfiles[i].getResource();
	            long fSize = mfiles[i].getSize();
	            boolean empty = mfiles[i].isEmpty();
	            */
	         }
	         int b = mapper.ProPicAdd(list);
	         }
	    	  
	         String msg = String.format("보드%d att", a);
	         return msg;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         return "파일 저장 실패:";
	      }
	} 

}
