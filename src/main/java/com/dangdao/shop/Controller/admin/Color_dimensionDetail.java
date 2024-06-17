package com.dangdao.shop.Controller.admin;

import com.dangdao.shop.entities.*;
import com.dangdao.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Color_dimensionDetail {

    @Autowired
    ProductService productService;

    @Autowired
    ColorService colorService;

    @Autowired
    DimensionService dimensionService;

    @Autowired
    ColorDetailService colorDetailService;

    @Autowired
    DimensionDetailService dimensionDetailService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    MaterialService materialService;

    @RequestMapping("/admin/ColorDetai_DimensionDetail")
    public String form(Model model) {
        List<Product> item = productService.findAll();
        List<Color> color = colorService.findAll();
        List<Dimension> dimension = dimensionService.findAll();
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List< Material> mtllist = materialService.findAll();
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("product", item.get(item.size() - 1));
        model.addAttribute("colors", color);
        model.addAttribute("dimensions", dimension);
        return "/views/admin/ColorDetai_DimensionDetails";
    }

    @RequestMapping("/admin/{message}")
    public String formMessage(Model model,@PathVariable("message") String message) {
        String[] m = message.split("-");
        List<Product> item = productService.findAll();
        List<Color> color = colorService.findAll();
        List<Dimension> dimension = dimensionService.findAll();
        List<ProductCategory> listPCtg = productCategoryService.findAll();
        List< Material> mtllist = materialService.findAll();
        model.addAttribute("mtllist", mtllist);
        model.addAttribute("listPC", listPCtg);
        model.addAttribute("message", m[0]);
        model.addAttribute("product", productService.findById(Integer.parseInt(m[1])));
        model.addAttribute("colors", color);
        model.addAttribute("dimensions", dimension);
        model.addAttribute("dimensionDetail", dimensionDetailService.findByProductId(Integer.parseInt(m[1])));
        model.addAttribute("colorDetail", colorDetailService.findByProductId(Integer.parseInt(m[1])));
        return "/views/admin/ColorDetai_DimensionDetails";
    }

    @PostMapping("/admin/create/colorDetail/{id}")
    public String createColordetail(Model model, @PathVariable("id") Integer id, @RequestParam(value = "cers", required = false) int[] cers) {
        Product product = productService.findById(id);
        List<ColorDetail> colorDetails = colorDetailService.findByProductId(id);
        if (cers != null) {
            for (int i = 0; i < cers.length; i++) {
                if (colorDetails.size()==0){
                    System.out.println("done");
                    ColorDetail colorDetail = new ColorDetail();
                    colorDetail.setColor(colorService.findById(cers[i]));
                    colorDetail.setProduct(product);
                    colorDetailService.create(colorDetail);
                }
                else {
                    for (ColorDetail c :
                            colorDetails) {
                        if (c.getId() != cers[i]) {
                            ColorDetail colorDetail = new ColorDetail();
                            colorDetail.setColor(colorService.findById(cers[i]));
                            colorDetail.setProduct(product);
                            colorDetailService.create(colorDetail);
                        }
                    }
                }
            }
            if (dimensionDetailService.findByProductId(id) != null) {
                product.setStatus(1);
                productService.update(product);
            }
            List<Product> item = productService.findAll();
            List<Color> color = colorService.findAll();
            List<Dimension> dimension = dimensionService.findAll();

            model.addAttribute("items", item.get(item.size() - 1));
            model.addAttribute("colors", color);
            model.addAttribute("dimensions", dimension);
            return "redirect:/admin/Done-"+id;
        } else {
            return "redirect:/admin/Errors-"+id;
        }


    }

    @PostMapping("/admin/create/dimensionDetail/{id}")
    public String createDimensiondetail(Model model, @PathVariable("id") Integer id, @RequestParam(value = "cers", required = false) int[] cers
            , @RequestParam(value = "prices", required = false) String[] prices) {
        List<Dimension> dimensions = dimensionService.findAll();
        Product product = productService.findById(id);
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] != null) {
                count++;
            }
        }
        if (count == 0) {
            return "redirect:/admin/Errors-"+id;
        } else {
            if (cers != null) {
                for (int j = 0; j < cers.length; j++) {
                    for (int i = 0; i < dimensions.size(); i++) {
                        if (cers[j] == dimensions.get(i).getId()) {
                            if (prices[i] != null) {
                                DimensionDetail d = new DimensionDetail();
                                d.setDimension(dimensionService.findById(cers[j]));
                                d.setProduct(product);
                                d.setPrice(Double.parseDouble(prices[i]));
                                dimensionDetailService.create(d);
                            } else {
                                return "redirect:/admin/Errors-"+id;
                            }
                        }
                    }
                }
                if (colorDetailService.findByProductId(id) != null) {
                    product.setStatus(1);
                    productService.update(product);
                }
            } else {
                return "redirect:/admin/Errors-"+id;
            }
            List<Product> item = productService.findAll();
            List<Color> color = colorService.findAll();
            List<Dimension> dimension = dimensionService.findAll();

            model.addAttribute("items", item.get(item.size() - 1));
            model.addAttribute("colors", color);
            model.addAttribute("dimensions", dimension);

            return "redirect:/admin/Done-"+id;
        }
    }
}
