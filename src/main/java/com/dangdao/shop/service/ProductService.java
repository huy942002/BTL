package com.dangdao.shop.service;

import com.dangdao.shop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface ProductService {

    public Page<Product> findPage(int pageNumber);

    public Page<Product> findPageHome(int pageNumber);
    public List<Product> findAll() ;

    public Product findById(Integer id) ;

    public List<Product> findByProductCategoryId(int productCategoryid) ;

    public Product create(Product product) ;

    public Product update(Product product) ;

    public void delete(Integer id) ;
}
