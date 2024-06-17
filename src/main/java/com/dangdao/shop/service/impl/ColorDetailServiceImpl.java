package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.ColorDetailDAO;
import com.dangdao.shop.entities.ColorDetail;
import com.dangdao.shop.service.ColorDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ColorDetailServiceImpl implements ColorDetailService {

    @Autowired
    ColorDetailDAO dao;

    @Override
    public List<ColorDetail> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ColorDetail> findByProductId(Integer id) {
        return dao.findByProductId(id);
    }

    @Override
    public ColorDetail create(ColorDetail colorDetail) {
        return dao.save(colorDetail);
    }

    @Override
    public void delete(Integer id) {
    dao.deleteById(id);
    }
}
