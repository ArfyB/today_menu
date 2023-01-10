package com.today.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
private int num;
private int count;
private String name;
private String price;
private String coo;
private String weight;
private String brand;
private java.sql.Date expire;
private String ca;
private String type;
private String id;
private String pdpic;
private String ppic;
}