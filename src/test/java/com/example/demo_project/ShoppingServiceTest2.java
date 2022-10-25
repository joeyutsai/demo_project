package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product2;
import com.example.demo_project.service.ifs.ShoppingService2;

@SpringBootTest
public class ShoppingServiceTest2 {
	@Autowired
	private ShoppingService2 shoppingService2;

	@Test
	public void shoppingServiceTest2() {
		// set list product
		Product2 appleProduct = new Product2("apple", 25, 20, 100);
		Product2 tomatoProduct = new Product2("tomato", 20, 10, 50);
		Product2 kiwiProduct = new Product2("kiwi", 10, 30, 300);
		List<Product2> listProduct = new ArrayList<>();
		listProduct.add(appleProduct);
		listProduct.add(tomatoProduct);
		listProduct.add(kiwiProduct);
		
		// query product
		List<String> queryList = new ArrayList<>();
		queryList.add("apple");
		queryList.add("tomato");
		queryList.add("kiwi");
		shoppingService2.queryProducts(queryList, listProduct);
		System.out.println();
		
		List<String> emptyList = new ArrayList<>();
//		shoppingService2.queryProducts(emptyList, listProduct);
		
		List<String> withoutItemList = new ArrayList<>();
		withoutItemList.add("apple");
		withoutItemList.add("tomato");
		withoutItemList.add("kiwi");
		withoutItemList.add("grava");
		withoutItemList.add("John");
//		shoppingService2.queryProducts(withoutItemList, listProduct); // ERROR!!
		
		shoppingService2.checkout(listProduct);

	}
}
