package com.dangdao.shop.service;

import com.dangdao.shop.entities.Dimension;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface DimensionService {
    public List<Dimension> findAll() ;

    public Dimension findById(Integer id) ;

    public Dimension create(Dimension dimension) ;

    public void delete(Integer id) ;
}
