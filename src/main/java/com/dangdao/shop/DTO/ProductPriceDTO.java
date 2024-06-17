package com.dangdao.shop.DTO;

import com.dangdao.shop.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceDTO {
    private Product product;
    private double priceMin;
}
