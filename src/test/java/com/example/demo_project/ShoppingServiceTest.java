package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@SpringBootTest
public class ShoppingServiceTest {
	@Autowired
	private ShoppingService shoppingService;

	@Test
	public void shoppingService() {
		//set products
		Product shirtProduct = new Product("shirt", 800, 10);
		Product jacketProduct = new Product("jacket", 1500, 20);
		Product walletProduct = new Product("wallet", 1800, 5);
		List<Product> listProduct = new ArrayList<>();
		listProduct.add(shirtProduct);
		listProduct.add(jacketProduct);
		listProduct.add(walletProduct);
		System.out.println();
		//search products
		List<String> serchProduct = new ArrayList<>(); 
		serchProduct.add("shirt");
		serchProduct.add("jacket");
		serchProduct.add("wallet");
		serchProduct.add("shoes");
		shoppingService.queryProducts(serchProduct, listProduct);
		System.out.println();
		//buy products
		List<Product> buyProduct = new ArrayList<>();
		Product buyshirtProduct = new Product("shirt", 5);
		Product buyjacketProduct = new Product("jacket", 10);
		Product buywalletProduct = new Product("wallet", 1);
		buyProduct.add(buyshirtProduct);
		buyProduct.add(buyjacketProduct);
		buyProduct.add(buywalletProduct);
		shoppingService.checkout(buyProduct, listProduct);
	}

}
