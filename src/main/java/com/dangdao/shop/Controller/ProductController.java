package com.dangdao.shop.Controller;

import com.dangdao.shop.DAO.DimensionDetailDAO;
import com.dangdao.shop.DAO.ProductDAO;
import com.dangdao.shop.DTO.ProductPriceDTO;
import com.dangdao.shop.entities.*;
import com.dangdao.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    TotalCategoryService totalCategoryService;

    @Autowired
    MaterialCategoryService materialCategoryService;

    @Autowired
    MaterialService materialService;

    @Autowired
    ColorDetailService colorDetailService;

    @Autowired
    DimensionDetailService dimensionDetailService;

    @Autowired
    DimensionDetailDAO dimensionDetailDAO;

    @Autowired
    ProductDAO productDAO;

    @RequestMapping("/product/{pageNumber}")
    public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
        Page<Product> page = productService.findPageHome(currentPage);
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<Product> item = page.getContent();
        List<ProductPriceDTO> items = new ArrayList<>();
        for (Product product :
                item) {
            ProductPriceDTO productPriceDTO = new ProductPriceDTO();
            productPriceDTO.setProduct(product);
            productPriceDTO.setPriceMin(dimensionDetailDAO.findByProductMINId(product.getId()));
            items.add(productPriceDTO);
        }

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);

        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List<TotalCategory> ttcList = totalCategoryService.findAll();
        List<MaterialCategory> materialCategories = materialCategoryService.findAll();
        List<Material> materials = materialService.findAll();
        model.addAttribute("items",items);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("listttc", ttcList);
        model.addAttribute("materials", materials);

//        model.addAttribute("dimensionDetail", dimensionDetailService.findByProductId(id));
//        model.addAttribute("colorDetail", colorDetailService.findByProductId(id));

        return "views/productList";
    }

    @RequestMapping("/product")
    public String getAllPages(Model model){
        return getOnePage(model, 1);
    }


    @RequestMapping("/product/detail/{id}")
    public String ProductDetail(Model model,@PathVariable("id") Integer id){
        Product item = productService.findById(id);
        List<Product> relatedProduct= productDAO.findByProductCategoryId(item.getProductCategory().getId());

        List<ProductPriceDTO> items = new ArrayList<>();

        for (Product r:
             relatedProduct) {
            ProductPriceDTO productPriceDTO = new ProductPriceDTO();
            productPriceDTO.setProduct(r);
            productPriceDTO.setPriceMin(dimensionDetailDAO.findByProductMINId(r.getId()));
            items.add(productPriceDTO);
        }
        model.addAttribute("relatedProduct",items);
        model.addAttribute("product",item);
        model.addAttribute("dimensionDetail", dimensionDetailService.findByProductId(id));
        model.addAttribute("colorDetail", colorDetailService.findByProductId(id));
        return "views/productDetail";
    }


}
