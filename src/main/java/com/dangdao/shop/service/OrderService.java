package com.dangdao.shop.service;

import com.dangdao.shop.entities.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    public List<Orders> findAll() ;

    public Orders findById(Integer id) ;

    public List<Orders> findByOrdersdt(String sdt) ;

    public Orders create(Orders order) ;

    public Orders update(Orders order) ;

    public void delete(Integer id) ;
}
