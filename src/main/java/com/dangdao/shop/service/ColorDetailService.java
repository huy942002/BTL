package com.dangdao.shop.service;


import com.dangdao.shop.entities.ColorDetail;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface ColorDetailService {
    public List<ColorDetail> findAll() ;

    public List<ColorDetail> findByProductId(Integer id);

    public ColorDetail create(ColorDetail colorDetail) ;

    public void delete(Integer id) ;
}
