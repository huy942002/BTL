package com.dangdao.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @RequestMapping("/cart/view")
    public String cartView(){
        return "views/cart-view";
    }

}
