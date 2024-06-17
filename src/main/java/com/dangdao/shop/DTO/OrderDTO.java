package com.dangdao.shop.DTO;

import com.dangdao.shop.entities.Orders;
import com.dangdao.shop.entities.Orderdetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    Orders order;
    List<Orderdetail> orderDetailList;
}
