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
public class ColorAdminController {

    @Autowired
    ColorService colorService;

    @Autowired
    UploadService uploadService;

    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;

    @Autowired
    MaterialCategoryService materialCategoryService;

    @PostMapping("/admin/color")
    public String create(Model model,@Valid Color color, @RequestParam("image") MultipartFile uploadFile, BindingResult result
                         ,ProductCategory productCategory, TotalCategory totalCategory, Dimension dimension, Material material
                         , MaterialCategory materialCategory,Product product){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm Màu Lỗi!");
        }else{
            Color c = new Color();
            c.setColorName(color.getColorName());
            c.setImg(uploadFile.getOriginalFilename());
            uploadService.store(uploadFile);
            colorService.create(c);
            model.addAttribute("message","Thêm Màu Thành Công!");
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

    @RequestMapping("/admin/color/{id}/")
    public String update(Model model
            ,@PathVariable("id") Integer id
            ,@RequestParam("colorName") String colorName
            ,@RequestParam("image") MultipartFile uploadFile){
        Color c =new Color();
        c.setId(id);
        if (uploadFile.getOriginalFilename().length()==0){
            c.setImg(colorService.findById(id).getImg());
        }else{
            c.setImg(uploadFile.getOriginalFilename());
            uploadService.store(uploadFile);
        }
        if (colorName.trim()==null){
            c.setColorName(colorService.findById(id).getColorName());
        }else{
            c.setColorName(colorName);
        }
        colorService.create(c);
        return "redirect:/admin/product";
    }

}
