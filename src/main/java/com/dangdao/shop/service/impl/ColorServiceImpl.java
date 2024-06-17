package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.ColorDAO;
import com.dangdao.shop.entities.Color;
import com.dangdao.shop.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    ColorDAO dao;

    @Override
    public List<Color> findAll() {
        return dao.findAll();
    }

    @Override
    public Color findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public Color create(Color color) {
        return dao.save(color);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
