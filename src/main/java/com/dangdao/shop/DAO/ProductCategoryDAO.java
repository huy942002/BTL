package com.dangdao.shop.DAO;


import com.dangdao.shop.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductCategoryDAO extends JpaRepository<ProductCategory, Integer> {
}
