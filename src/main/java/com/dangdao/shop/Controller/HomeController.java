package com.dangdao.shop.Controller;

import com.dangdao.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/index","/home"})
    public String home() {
        return "/views/home";
    }

    @RequestMapping({"/admin/home","/admin"})
    public String homeadmin() {

        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/admin/product/form")
    public String formadmin() {
        return "redirect:/admin/form";
    }

    @RequestMapping("/admin/product/list")
    public String productlistadmin() {
        return "redirect:/admin/product";
    }
}
