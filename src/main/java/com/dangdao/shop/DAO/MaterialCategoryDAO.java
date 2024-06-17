package com.dangdao.shop.DAO;

import com.dangdao.shop.entities.MaterialCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MaterialCategoryDAO extends JpaRepository<MaterialCategory, Integer> {
}
