package com.dangdao.shop.service;

import com.dangdao.shop.entities.ProductCategory;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface ProductCategoryService {
    public List<ProductCategory> findAll() ;

    public ProductCategory findById(Integer id) ;

    public ProductCategory create(ProductCategory productCategory) ;

    public ProductCategory update(ProductCategory productCategory) ;

    public void delete(Integer id) ;
}
