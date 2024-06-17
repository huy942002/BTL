package com.dangdao.shop.DAO;


import com.dangdao.shop.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MaterialDAO extends JpaRepository<Material, Integer> {
}
