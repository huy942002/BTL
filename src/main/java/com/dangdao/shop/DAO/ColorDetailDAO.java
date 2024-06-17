package com.dangdao.shop.DAO;

import com.dangdao.shop.entities.ColorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ColorDetailDAO extends JpaRepository<ColorDetail, Integer> {
    @Query("SELECT c FROM ColorDetail c WHERE c.product.id=?1")
    List<ColorDetail> findByProductId(Integer id);
}
