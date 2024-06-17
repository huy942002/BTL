package com.dangdao.shop.Controller;

import com.dangdao.shop.DAO.ColorDetailDAO;
import com.dangdao.shop.DAO.DimensionDAO;
import com.dangdao.shop.DAO.DimensionDetailDAO;
import com.dangdao.shop.entities.*;
import com.dangdao.shop.service.ColorService;
import com.dangdao.shop.service.DimensionDetailService;
import com.dangdao.shop.service.DimensionService;
import com.dangdao.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @Autowired
    DimensionDetailService dimensionDetailService;

    @Autowired
    ColorService colorService;

    @Autowired
    ColorDetailDAO colorDetailDAO;


    @Autowired
    DimensionService dimensionService;

    @Autowired
    DimensionDetailDAO dao;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productService.findById(id);
    }

    @GetMapping("/dimensiondetails/{id}")
    public List<DimensionDetail> getDimensionDetails(@PathVariable("id") Integer id){
        return dimensionDetailService.findByProductId(id);
    }

    @GetMapping("/dimensiondetail/{id1}/{id2}")
    public DimensionDetail getDimensionDetail(@PathVariable("id1") Integer id1,@PathVariable("id2") Integer id2){
        return dao.findByProductAndDimension(id1,id2);
    }

    @GetMapping("/dimension/{id}")
    public Dimension getDimension(@PathVariable("id") Integer id){
        return dimensionService.findById(id);
    }

    @GetMapping("/color/{id}")
    public Color getColor(@PathVariable("id") Integer id){
        return colorService.findById(id);
    }

    @GetMapping("/colorDetail/{id}")
    public List<ColorDetail> getColorDetail(@PathVariable("id") Integer id){
        return colorDetailDAO.findByProductId(id);
    }

}
