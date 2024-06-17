package com.dangdao.shop.DAO;


import com.dangdao.shop.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDAO extends JpaRepository<Orders, Integer> {
}
