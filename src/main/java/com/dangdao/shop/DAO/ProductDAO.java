package com.dangdao.shop.DAO;


import com.dangdao.shop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p LEFT JOIN ProductCategory pc ON p.productCategory = pc LEFT JOIN TotalCategory tc ON pc.totalCategory = tc WHERE tc.id = ?1 GROUP BY p.id")
    public List<Product> findBytotalId(Integer id);

    @Query("SELECT p FROM Product p  WHERE p.productCategory.id = ?1")
    public List<Product> findByProductCategoryId(Integer id);
}
