package com.dangdao.shop.Controller.admin;

import com.dangdao.shop.entities.*;
import com.dangdao.shop.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryAdminController {
    @Autowired
    ProductService productService;

    @Autowired
    ColorService colorService;

    @Autowired
    DimensionService dimensionService;

    @Autowired
    MaterialCategoryService materialCategoryService;

    @Autowired
    ProductCategoryService categoryService;

    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;

    @PostMapping("/admin/category")
    public String create(Model model, @Valid ProductCategory productCategory, BindingResult result, TotalCategory totalCategory
            , Color color, Dimension dimension
            , Material material, MaterialCategory materialCategory,Product product){
        if (result.hasErrors()){
            model.addAttribute("message","Danh Mục Lỗi!");
        }else {
            categoryService.create(productCategory);
            model.addAttribute("message","Danh Mục Thêm Thành Công!");
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

    @RequestMapping("/admin/category/{id}/")
    public String update(Model model
            ,@PathVariable("id") Integer id
            ,@RequestParam(value = "ttid", required = false) Integer  ttid
            ,@RequestParam(value = "CategoryName", required = false) String CategoryName){
        ProductCategory p = new ProductCategory();
        if (CategoryName.trim()==null){
            p.setProductCategoryName(productCategoryService.findById(id).getProductCategoryName());
        }else{
            p.setProductCategoryName(CategoryName.trim());
        }
        p.setId(id);
        p.setTotalCategory(totalCategoryService.findById(ttid));

        productCategoryService.update(p);

        return "redirect:/admin/product";
    }
}
