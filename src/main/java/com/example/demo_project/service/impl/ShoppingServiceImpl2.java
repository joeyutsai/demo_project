package com.example.demo_project.service.impl;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.entity.Product2;
import com.example.demo_project.service.ifs.ShoppingService2;

@Service
public class ShoppingServiceImpl2 implements ShoppingService2 {

//  // teacher method
//	@Override
//	public void queryProducts(List<String> queryNameList, List<Product2> productList) {
//		// search name can't empty
//		if (queryNameList.isEmpty()) {
//			System.out.println("Search item can't be empty.");
//			return;
//		}
//		Map<String, Product2> queryMap = new HashMap<>();
//		for (String nameItem : queryNameList) {
//			for (Product2 productItem : productList) {
//				if (nameItem.equalsIgnoreCase(productItem.getName())) {
//					queryMap.put(nameItem, productItem);
////					System.out.println("PRODUCT: " + productItem.getName() + ", PRICE: $" + productItem.getPrice()
////							+ ", STORAGE: " + productItem.getStorage());
//					break;
//				} else {
//					queryMap.put(nameItem, null);
////					System.out.println("Sorry! We don't have " + nameItem);
//					break;
//				}
//			}
//		}
//		for (Map.Entry<String, Product2> mapItem : queryMap.entrySet()) {
//			if (mapItem.getValue() == null) {
//				System.out.println("Sorry! We don't have " + mapItem.getKey());
//			} else {
//				Product2 product = mapItem.getValue();
//				System.out.println("ITEM: " + product.getName() + ", PRICE: $" + product.getPrice() + ", STORAGE: "
//						+ product.getStorage());
//			}
//		}
//	}

	@Override
	public void queryProducts(List<String> queryNameList, List<Product2> productList) {
		System.out.println("== QUERY PRODUCT LIST ==");
		// search name can't empty
		if (queryNameList.isEmpty()) {
			System.out.println("Search item can't be empty.");
			return;
		}
		for (String nameItem : queryNameList) {
			for (int i = 0; i < productList.size(); i++) {
				if (nameItem.equalsIgnoreCase(productList.get(i).getName())) {
					System.out.println("PRODUCT: " + productList.get(i).getName() + ", PRICE: $"
							+ productList.get(i).getPrice() + ", STORAGE: " + productList.get(i).getStorage());
					break;
				} else if (i == (productList.size() - 1)) {
					System.out.println("Sorry! We don't have " + nameItem);
				}
			}
		}
	}

	@Override
	public void checkout(List<Product2> productList) {
		int totalPrice = 0;
		System.out.println("== BUY LIST ==");
		for (Product2 item : productList) {
			System.out.println("ITEM: " + item.getName() + ", QUANTITY: " + item.getQuantity() + ", ITEM TOTAL PRICE: $"
					+ (item.getPrice() * item.getQuantity()));
			item.setStorage(item.getStorage() - item.getQuantity());
			totalPrice += (item.getPrice() * item.getQuantity());
		}
		System.out.println("TOTAL PRICE: $" + totalPrice);
		System.out.println();
		System.out.println("== RENEW PRODUCT LIST ==");
		for (Product2 item : productList) {
			System.out.println(
					"PRODUCT: " + item.getName() + ", PRICE: $" + item.getPrice() + ", STORAGE: " + item.getStorage());
		}

	}

}
