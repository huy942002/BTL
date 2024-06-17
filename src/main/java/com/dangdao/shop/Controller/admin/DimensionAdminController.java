package com.dangdao.shop.Controller.admin;

import com.dangdao.shop.entities.*;
import com.dangdao.shop.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DimensionAdminController {

    @Autowired
    DimensionService dimensionService;

    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;
    @Autowired
    MaterialCategoryService materialCategoryService;

    @PostMapping("/admin/dimension")
    public String create(Model model, Color color, @RequestParam("image") MultipartFile uploadFile, BindingResult result
            , ProductCategory productCategory, TotalCategory totalCategory,@Valid Dimension dimension, Material material
            , MaterialCategory materialCategory, Product product){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm Kích Thước Lỗi!");
        }else{
            Dimension d = new Dimension();
            d.setSize(dimension.getSize());
            model.addAttribute("message","Thêm Kích Thước Thành Công!");
        }
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List<Material> mtllist = materialService.findAll();
        List<TotalCategory> ttcList = totalCategoryService.findAll();
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);
        model.addAttribute("mtctgllist", materialCategoryService.findAll());
        return "/views/admin/forms";
    }

    @RequestMapping("/admin/dimension/{id}/")
    public String update(Model model
            ,@PathVariable("id") Integer id
            ,@RequestParam("size") String size){
        Dimension d = new Dimension();
        d.setId(id);
        if(size.trim()==null){
            d.setSize(dimensionService.findById(id).getSize());
        }else{
            d.setSize(size.trim());
        }
        dimensionService.create(d);
        return "redirect:/admin/product";
    }

}
