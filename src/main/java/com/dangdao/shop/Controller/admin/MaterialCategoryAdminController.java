package com.dangdao.shop.Controller.admin;

import com.dangdao.shop.entities.*;
import com.dangdao.shop.service.MaterialCategoryService;
import com.dangdao.shop.service.MaterialService;
import com.dangdao.shop.service.ProductCategoryService;
import com.dangdao.shop.service.TotalCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MaterialCategoryAdminController {

    @Autowired
    MaterialCategoryService materialCategoryService;

    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;

    @PostMapping("/admin/materialCategory")
    public String create(Model model, Color color, BindingResult result, ProductCategory productCategory, TotalCategory totalCategory
            , Dimension dimension, Material material,@Valid MaterialCategory materialCategory,Product product){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm Thể Loại Vật Liệu Lỗi!");
        }else{
            materialCategoryService.create(materialCategory);
            model.addAttribute("message","Thêm Thể Loại Vật Liệu Thành Công!");
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
}
