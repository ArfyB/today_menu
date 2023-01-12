package com.today.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.extra.spath.AbsolutePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.today.mapper.CategoryMapper;
import com.today.vo.Category;
import com.today.vo.Product;
import com.today.vo.ProductPic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MallService 
{
   @Autowired
   ResourceLoader resourceLoader; 
   
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
   public List<Category> CdList(String ca)
   {
      List<Category> CdList = mapper.CdList(ca);

      return CdList;
   }
   public List<Product> ProductD(String ca)
   {
      List<Product> ProductD = mapper.ProductD(ca);

      return ProductD;
   }
   public List<Product> getN(String ca)
   {
      List<Product> getN = mapper.getN(ca);

      return getN;
   }
   public boolean ProductAdd(Product pro)
   {
      boolean added = 0<mapper.ProductAdd(pro);
      return added;
   }
   
   public boolean addPA(Map map)
   {
      
      MultipartFile[] mfiles = (MultipartFile[]) map.get("mfiles");
      HttpServletRequest request = (HttpServletRequest) map.get("request");
      Product pro = (Product) map.get("product");
      
      ServletContext context = request.getServletContext();
      
         /*
         Resource resource = resourceLoader.getResource("classpath:/static");
         try 
         {
         String absolutePath = resource.getFile().getAbsolutePath();
         System.out.println("스태틱" + absolutePath);
         } 
         
         catch (IOException e1) 
         {
         e1.printStackTrace();
         }
         */
         
         List<ProductPic> list = new ArrayList<>();
         String absolutePath="";
         
         Resource resource = resourceLoader.getResource("classpath:/static");
         
         try 
         {
        	 absolutePath = resource.getFile().getAbsolutePath();
            if(mfiles.length != 0)
            {
               
            for(int i=0;i<mfiles.length;i++) 
            {
               System.out.println("스태틱  " + absolutePath + "/pics/" + mfiles[i].getOriginalFilename());
               mfiles[i].transferTo(
               new File(absolutePath+"/pics/"+mfiles[i].getOriginalFilename()));
               
               ProductPic pp = new ProductPic();
               pp.setFname(mfiles[i].getOriginalFilename());
               pro.setPpic(mfiles[i].getOriginalFilename());
               
               
               list.add(pp);
            }
            
            int a = mapper.ProductAdd(pro);
            System.out.println(list.get(0));
            int b = mapper.ProPicAdd(list);
            
            }
            
            return true;
            
         } catch (Exception e) {
            e.printStackTrace();
            return false;
         }
   } 
   
   public Product getProduct(Product pro)
   {
      return mapper.getProduct(pro);
   }

}