package com.dangdao.shop.service;


import com.dangdao.shop.entities.Color;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface ColorService {
    public List<Color> findAll() ;

    public Color findById(Integer id);
    public Color create(Color color) ;

    public void delete(Integer id) ;
}
