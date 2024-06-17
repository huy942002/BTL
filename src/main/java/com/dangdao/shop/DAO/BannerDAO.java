package com.dangdao.shop.DAO;


import com.dangdao.shop.entities.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerDAO extends JpaRepository<Banner, Integer> {
}