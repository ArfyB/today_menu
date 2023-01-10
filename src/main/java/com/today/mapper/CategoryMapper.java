package com.today.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.today.vo.Category;
import com.today.vo.Product;
import com.today.vo.ProductPic;

@Mapper
public interface CategoryMapper 
{
	public List<Category> CategoryList();
	public List<Product> ProductList();
	public List<Category> clist();
	public int ProductAdd(Product pro);
	public int ProPicAdd(List<ProductPic> list);
	public Product getProduct(Product pro);
}




