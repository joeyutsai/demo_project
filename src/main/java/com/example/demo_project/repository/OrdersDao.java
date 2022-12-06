package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_project.entity.Orders;
import com.example.demo_project.vo.OrdersInfo;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

	@Query("select new com.example.demo_project.vo.OrdersInfo(o.customerId, c.name, o.productName, o.quantity) from Orders o join Customers c on o.customerId=c.id ")
	public List<OrdersInfo> findAllOrdersInfo();
	
//	// 無法轉型
//	@Query("select Orders.customerId, Orders.productName, Orders.quantity, Customers.name from Orders join Customers on Orders.customerId=Customers.id")
//	public List<Object> findAllOrdersInfo2();
	
	
//	@Query()
//	public List<OrdersInfo> findOrdersInfoByCustomerIdIn();
	
}
