package com.today.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
private String name;
private int num;
private String expire;
private String coo;
private String weight;
private String type;
private String brand;
}
