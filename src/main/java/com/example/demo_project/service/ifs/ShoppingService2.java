package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Product2;

public interface ShoppingService2 {
	public void queryProducts(List<String> nameList, List<Product2> productList);
	public void checkout(List<Product2> productList);
}
