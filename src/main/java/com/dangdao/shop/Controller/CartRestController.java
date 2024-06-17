package com.dangdao.shop.Controller;

import com.dangdao.shop.DTO.OrderDTO;
import com.dangdao.shop.entities.Orders;
import com.dangdao.shop.entities.Orderdetail;
import com.dangdao.shop.service.OrderService;
import com.dangdao.shop.service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class CartRestController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderdetailService orderdetailService;

    @PostMapping("/cart")
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO){
        orderService.create(orderDTO.getOrder());
        List<Orders> orderList = orderService.findAll();
        for (Orderdetail orderdetail :
                orderDTO.getOrderDetailList()) {
            Orderdetail o = new Orderdetail();
            o.setProduct(orderdetail.getProduct());
            o.setColor(orderdetail.getColor());
            o.setDimension(orderdetail.getDimension());
            o.setOrder(orderList.get(orderList.size()-1));
            o.setPrice(orderdetail.getPrice());
            o.setQuantity(orderdetail.getQuantity());
            o.setStatus(orderdetail.getStatus());
            orderdetailService.create(o);
            
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
