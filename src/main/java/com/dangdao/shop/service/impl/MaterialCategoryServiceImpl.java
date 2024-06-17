package com.dangdao.shop.service.impl;


import com.dangdao.shop.DAO.MaterialCategoryDAO;
import com.dangdao.shop.entities.MaterialCategory;
import com.dangdao.shop.service.MaterialCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterialCategoryServiceImpl implements MaterialCategoryService {
    @Autowired
    MaterialCategoryDAO dao;

    @Override
    public List<MaterialCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public MaterialCategory create(MaterialCategory materialCategory) {
        return dao.save(materialCategory);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
