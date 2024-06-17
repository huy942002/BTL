package com.dangdao.shop.Controller.admin;

import com.dangdao.shop.entities.Orderdetail;
import com.dangdao.shop.service.OrderService;
import com.dangdao.shop.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderDetailAdminController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderdetailService orderdetailService;

    @RequestMapping("/admin/dashboard")
    public String orderDetailList(Model model){
        model.addAttribute("listOrder", orderService.findAll());
        return "/views/admin/dashboard";
    }

    @RequestMapping("/admin/orderDetail/{id}")
    public String orderDetailList(Model model,@PathVariable("id") Integer id){
        model.addAttribute("listOrderDetail",orderdetailService.findByorderId(id));
        model.addAttribute("listOrder", orderService.findById(id));
        return "/views/admin/OrderDetail";
    }

    @RequestMapping("/admin/orderDetail/edit/{id1}/{id2}")
    public String orderDetailUpdateStatus(Model model,@PathVariable("id1") Integer id1,@PathVariable("id2") Integer id2){
        Orderdetail orderdetail = orderdetailService.findById(id1);
        orderdetail.setStatus(0);
        orderdetailService.update(orderdetail);
        model.addAttribute("listOrderDetail",orderdetailService.findByorderId(id1));
        model.addAttribute("listOrder", orderService.findById(id2));
        return "/views/admin/OrderDetail";
    }
}
