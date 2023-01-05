package com.today.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.today.vo.Category;

@Mapper
public interface CategoryMapper 
{
	public List<Category> list();
}
