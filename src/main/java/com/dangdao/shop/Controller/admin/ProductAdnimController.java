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
public class ProductAdnimController {
    @Autowired
    ProductService productService;

    @Autowired
    MaterialCategoryService materialCategoryService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    MaterialService materialService;

    @Autowired
    ColorService colorService;

    @Autowired
    DimensionService dimensionService;

    @Autowired
    UploadService uploadService;

    @Autowired
    ColorDetailService colorDetailService;

    @Autowired
    DimensionDetailService dimensionDetailService;

    @RequestMapping("/admin/form")
    public String orderDetailList(Model model, Color color, Dimension dimension,ProductCategory productCategory
            ,TotalCategory totalCategory,Material material,MaterialCategory materialCategory,Product product){
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List< Material> mtllist = materialService.findAll();
        List<TotalCategory> ttcList = totalCategoryService.findAll();
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);
        model.addAttribute("mtctgllist", materialCategoryService.findAll());
        return "/views/admin/forms";
    }

    @RequestMapping("/admin/product")
    public String getOnePage(Model model) {
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
        model.addAttribute("item", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);

        return "views/admin/tables";
    }

    @PostMapping("/admin/add")
    public String create(Model model, @Valid Product product, @RequestParam("file") MultipartFile file, BindingResult result){
        if (result.hasErrors()){
            model.addAttribute("message","Thêm Sản Phẩm Lỗi!");
            List<ProductCategory> listPCtg = productCategoryService.findAll();
            List<Material> mtllist = materialService.findAll();
            List<TotalCategory> ttcList = totalCategoryService.findAll();
            model.addAttribute("mtllist", mtllist);
            model.addAttribute("listPC", listPCtg);
            model.addAttribute("listttc", ttcList);
            return "/views/admin/forms";
        } else if (file.getOriginalFilename().length()==0) {
            model.addAttribute("message","Thêm Sản Phẩm Lỗi!");
            List<ProductCategory> listPCtg = productCategoryService.findAll();
            List<Material> mtllist = materialService.findAll();
            List<TotalCategory> ttcList = totalCategoryService.findAll();
            model.addAttribute("mtllist", mtllist);
            model.addAttribute("listPC", listPCtg);
            model.addAttribute("listttc", ttcList);
            return "/views/admin/forms";
        } else{
            Product p = new Product();
            p.setName(product.getName());
            p.setProductCategory(product.getProductCategory());
            p.setMaterial(product.getMaterial());
            p.setImg(file.getOriginalFilename());
            uploadService.store(file);
            productService.create(p);
            model.addAttribute("message","Thêm Sản Phẩm Thành Công!");
            List<Product> item = productService.findAll();
            List<Color> color = colorService.findAll();
            List<Dimension> dimension = dimensionService.findAll();
            model.addAttribute("items",item.get(item.size()-1));
            model.addAttribute("colors",color);
            model.addAttribute("dimensions",dimension);
            return "redirect:/admin/ColorDetai_DimensionDetail";
        }

    }

    @RequestMapping("/admin/edit/{id}")
    public String formedit(Model model,@PathVariable("id") Integer id) {
        Product item = productService.findById(id);
        List<Color> color = colorService.findAll();
        List<Dimension> dimension = dimensionService.findAll();
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List< Material> mtllist = materialService.findAll();
        List<TotalCategory> ttcList = totalCategoryService.findAll();
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);
        model.addAttribute("product",item);
        model.addAttribute("colors", color);
        model.addAttribute("dimensions", dimension);
        model.addAttribute("dimensionDetail", dimensionDetailService.findByProductId(id));
        model.addAttribute("colorDetail", colorDetailService.findByProductId(id));
        return "/views/admin/ColorDetai_DimensionDetails";
    }

    @RequestMapping("/admin/update/{id}")
    public String update(Model model,@PathVariable("id") Integer id, @Valid Product product, @RequestParam("file") MultipartFile file, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/admin/edit/"+id;
        } else if (file.getOriginalFilename().length()==0) {
            Product p = new Product();
            p.setId(id);
            p.setName(product.getName());
            p.setProductCategory(product.getProductCategory());
            p.setMaterial(product.getMaterial());
            p.setImg(productService.findById(id).getImg());
            productService.update(p);
            model.addAttribute("message","Update Sản Phẩm Thành Công!");
            List<Product> item = productService.findAll();
            List<Color> color = colorService.findAll();
            List<Dimension> dimension = dimensionService.findAll();
            model.addAttribute("items",item.get(item.size()-1));
            model.addAttribute("colors",color);
            model.addAttribute("dimensions",dimension);
            return "redirect:/admin/edit/"+id;
        } else{
            Product p = new Product();
            p.setId(id);
            p.setName(product.getName());
            p.setProductCategory(product.getProductCategory());
            p.setMaterial(product.getMaterial());
            p.setImg(file.getOriginalFilename());
            uploadService.store(file);
            productService.update(p);
            model.addAttribute("message","Update Sản Phẩm Thành Công!");
            List<Product> item = productService.findAll();
            List<Color> color = colorService.findAll();
            List<Dimension> dimension = dimensionService.findAll();
            model.addAttribute("items",item.get(item.size()-1));
            model.addAttribute("colors",color);
            model.addAttribute("dimensions",dimension);
            return "redirect:/admin/edit/"+id;
        }
    }

}
