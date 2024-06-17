package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.BannerDAO;
import com.dangdao.shop.entities.Banner;
import com.dangdao.shop.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceIml implements BannerService {
    @Autowired
    BannerDAO bannerDAO;

    @Override
    public List<Banner> findAll() {
        // Logic để tìm tất cả các Banner
        return bannerDAO.findAll();
    }


    @Override
    public Banner create(Banner b) {
        // Logic để tạo mới Banner
        return bannerDAO.save(b);
    }

    @Override
    public Banner update(Banner b) {
        // Logic để cập nhật Banner
        return bannerDAO.save(b);
    }

    @Override
    public void delete(Integer id) {
        bannerDAO.deleteById(id);
    }
}
