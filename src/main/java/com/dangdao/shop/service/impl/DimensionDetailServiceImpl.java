package com.dangdao.shop.service.impl;

import com.dangdao.shop.DAO.DimensionDetailDAO;
import com.dangdao.shop.entities.DimensionDetail;
import com.dangdao.shop.service.DimensionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class DimensionDetailServiceImpl implements DimensionDetailService {
    @Autowired
    DimensionDetailDAO dao;

    @Override
    public List<DimensionDetail> findAll() {
        return dao.findAll();
    }

    @Override
    public DimensionDetail create(DimensionDetail dimensionDetail) {
        return dao.save(dimensionDetail);
    }

    @Override
    public DimensionDetail findById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public List<DimensionDetail> findByProductId(Integer id) {
        return dao.findDimensionDetailByProductId(id);
    }

//    @Override
//    public List<DimensionDetail> findByProductId(Integer id) {
//        return dao.findByProductId(id);
//    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }
}
