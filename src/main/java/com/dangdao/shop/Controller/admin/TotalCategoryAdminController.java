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

import java.util.List;

@Controller
public class TotalCategoryAdminController {
    @Autowired
    ProductService productService;

    @Autowired
    ColorService colorService;

    @Autowired
    DimensionService dimensionService;

    @Autowired
    MaterialCategoryService materialCategoryService;
    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;

    @PostMapping("/admin/totalcategory")
    public String create(Model model, @Valid TotalCategory totalCategory, BindingResult result, Color color, Dimension dimension,ProductCategory productCategory
            ,Material material,MaterialCategory materialCategory,Product product){
        if (result.hasErrors()){
            model.addAttribute("message","Tổng Danh Mục Lỗi!");
        }else {
            totalCategoryService.create(totalCategory);
            model.addAttribute("message","Tổng Danh Mục Thêm Thành Công");
        }
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List< Material> mtllist = materialService.findAll();
        List<TotalCategory> ttcList = totalCategoryService.findAll();
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);
        return "/views/admin/forms";
    }

    @RequestMapping("/admin/totalcategory/{id}/")
    public String update(Model model
            ,@PathVariable("id") Integer id
            ,@RequestParam("totalCategoryName") String totalCategoryName){
        System.out.println(totalCategoryName);
        TotalCategory totalCategory = new TotalCategory();
        totalCategory.setId(id);
        if (totalCategoryName.trim() ==null){
            totalCategory.setName(totalCategoryService.findById(id).getName());
            System.out.println(totalCategoryService.findById(id).getName());
        }else{
            System.out.println(totalCategoryName);
            totalCategory.setName(totalCategoryName.trim());
        }
        totalCategoryService.create(totalCategory);
        List<Product> item = productService.findAll();

        List<Color> color = colorService.findAll();
        List<Dimension> dimension = dimensionService.findAll();
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List< Material> mtllist = materialService.findAll();
        List<TotalCategory> ttcList = totalCategoryService.findAll();
        List<MaterialCategory> materialCategories = materialCategoryService.findAll();
        model.addAttribute("mtlctg",materialCategories);
        model.addAttribute("items",item);
        model.addAttribute("colors",color);
        model.addAttribute("dimensions",dimension);
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);
        return "views/admin/tables";
    }

}
