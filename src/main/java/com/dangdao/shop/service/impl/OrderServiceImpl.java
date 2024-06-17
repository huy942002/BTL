package com.dangdao.shop.service.impl;


import com.dangdao.shop.DAO.OrderDAO;
import com.dangdao.shop.entities.Orders;
import com.dangdao.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO dao;

    @Override
    public List<Orders> findAll() {
        return dao.findAll();
    }

    @Override
    public Orders findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Orders> findByOrdersdt(String sdt) {
        return null;
    }

    @Override
    public Orders create(Orders order) {
        return dao.save(order);
    }

    @Override
    public Orders update(Orders order) {
        return dao.save(order);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
