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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MaterialAdminController {
    @Autowired
    MaterialCategoryService materialCategoryService;
    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;

    @PostMapping("/admin/material")
    public String create(Model model,  Color color, BindingResult result, ProductCategory productCategory, TotalCategory totalCategory
            , Dimension dimension,@Valid Material material, MaterialCategory materialCategory,Product product){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm Vật Liệu Lỗi!");
        }else{
            materialService.create(material);
            model.addAttribute("message","Thêm Vật Liệu Thành Công!");
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

    @RequestMapping("/admin/material/{id}/")
    public String update(Model model
            ,@PathVariable("id") Integer id
            ,@RequestParam("materialName") String materialName
            ,@RequestParam("price") Double price){
        return "redirect:/admin/product";
    }
}
