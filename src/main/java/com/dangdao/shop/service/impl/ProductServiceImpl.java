package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.ProductDAO;
import com.dangdao.shop.entities.Product;
import com.dangdao.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO dao;

    @Override
    public Page<Product> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1,10);
        return dao.findAll(pageable);
    }

    @Override
    public Page<Product> findPageHome(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1,16);
        return dao.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Product> findByProductCategoryId(int productCategoryid) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return dao.save(product);
    }

    @Override
    public Product update(Product product) {
        return dao.save(product);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
