package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.ProductCategoryDAO;
import com.dangdao.shop.entities.ProductCategory;
import com.dangdao.shop.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryDAO dao;

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public ProductCategory findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        return dao.save(productCategory);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return dao.save(productCategory);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
