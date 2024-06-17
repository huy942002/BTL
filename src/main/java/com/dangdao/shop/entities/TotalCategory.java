package com.dangdao.shop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQuery(name="TotalCategory.findAll", query="SELECT t FROM TotalCategory t")
public class TotalCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tổng thể loại không để trống")
    @Column(name="name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy="totalCategory")
    private List<ProductCategory> productCategories;
}
