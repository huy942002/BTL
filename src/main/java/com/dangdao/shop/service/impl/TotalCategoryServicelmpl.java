package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.TotalCategoryDAO;
import com.dangdao.shop.entities.TotalCategory;
import com.dangdao.shop.service.TotalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalCategoryServicelmpl implements TotalCategoryService {
    @Autowired
    TotalCategoryDAO totalCategoryDAO;

    @Override
    public List<TotalCategory> findAll() {
        return totalCategoryDAO.findAll();
    }

    @Override
    public TotalCategory create(TotalCategory totalCategory) {
        return totalCategoryDAO.save(totalCategory);
    }

    @Override
    public TotalCategory findById(Integer id) {
        return totalCategoryDAO.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        totalCategoryDAO.deleteById(id);
    }
}
