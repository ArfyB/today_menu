package com.today.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.today.mapper.CategoryMapper;
import com.today.vo.Category;

@Service
public class MallService 
{
	@Autowired
	public CategoryMapper mapper;
	
	public List<Category> list()
	{
		List<Category> list = mapper.list();
		return list;
	}
}
