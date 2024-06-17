package com.dangdao.shop.service;

import com.dangdao.shop.entities.Orderdetail;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface OrderdetailService {
    public List<Orderdetail> findAll() ;

    public Orderdetail findById(Integer id) ;

    public List<Orderdetail> findByorderId(int orderId) ;

    public Orderdetail create(Orderdetail orderdetail) ;

    public Orderdetail update(Orderdetail orderdetail) ;

    public void delete(Integer id) ;
}
