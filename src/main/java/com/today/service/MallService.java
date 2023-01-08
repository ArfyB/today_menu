package com.today.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.today.mapper.CategoryMapper;
import com.today.vo.Category;
import com.today.vo.Product;

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
}
