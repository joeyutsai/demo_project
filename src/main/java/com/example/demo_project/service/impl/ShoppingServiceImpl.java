package com.example.demo_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Override
	public void queryProducts(List<String> nameList, List<Product> productList) {
		for (int i = 0; i < nameList.size(); i++) {
			for (int j = 0; j < productList.size(); j++) {
				if (nameList.get(i) == productList.get(j).getName()) {
					System.out.println("PRODUCT: " + productList.get(j).getName() + ", PRICE: $"
							+ productList.get(j).getPrice() + ", STORAGE: " + productList.get(j).getStorage());
					break;
				} else if (j == (productList.size() - 1)) {
					System.out.println("Sorry! We don't have " + nameList.get(i) + " product.");
				}
			}
		}
	}

	@Override
	public void checkout(List<Product> buyList, List<Product> productList) {
		int totalPrice = 0; // set total price
		System.out.println("== BUY LIST ==");

		// add item price to total price &  print buy list & renew listProduct storage
		for (int i = 0; i < buyList.size(); i++) {
			for (int j = 0; j < productList.size(); j++) {
				if (buyList.get(i).getName() == productList.get(j).getName()) {
					// add item price to total price
					totalPrice += (buyList.get(i).getStorage() * productList.get(j).getPrice());
					// print buy list
					System.out.println("ITEM: " + buyList.get(i).getName() + ", QUANTITY: "
							+ buyList.get(i).getStorage() + ", ITEM PRICE: $"
							+ (buyList.get(i).getStorage() * productList.get(j).getPrice()));
					// renew storage
					productList.get(j).setStorage((productList.get(j).getStorage()) - (buyList.get(i).getStorage()));

				}
			}
		}

		// print total price
		System.out.println("TOTAL PRICE: $" + totalPrice);
		System.out.println();

		// print renew list product
		System.out.println("== RENEW LIST PRODUCT ==");
		for (int i = 0 ; i < productList.size(); i++) {
			System.out.println("PRODUCT: " + productList.get(i).getName() + ", PRICE: $"
					+ productList.get(i).getPrice() + ", STORAGE: " + productList.get(i).getStorage());
		}
	}

}
