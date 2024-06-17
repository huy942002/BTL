package com.dangdao.shop.service;

import com.dangdao.shop.entities.DimensionDetail;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface DimensionDetailService {
    public List<DimensionDetail> findAll() ;

    public DimensionDetail create(DimensionDetail dimensionDetail) ;

    public DimensionDetail findById(Integer id) ;

    public List<DimensionDetail> findByProductId(Integer id);

//    public List<DimensionDetail> findByProductId(Integer id);
    public void delete(Integer id) ;
}
