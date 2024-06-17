package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.DimensionDAO;
import com.dangdao.shop.entities.Dimension;
import com.dangdao.shop.service.DimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class DimensionServiceImpl implements DimensionService {
    @Autowired
    DimensionDAO dao;

    @Override
    public List<Dimension> findAll() {
        return dao.findAll();
    }

    @Override
    public Dimension findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public Dimension create(Dimension dimension) {
        return dao.save(dimension);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
