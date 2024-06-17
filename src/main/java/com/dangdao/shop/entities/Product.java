package com.dangdao.shop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

import java.util.List;
/**
 * The persistent class for the products database table.
 * 
 */
@SuppressWarnings("serial")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String img;

	private String name;

	private int status;

	//bi-directional many-to-one association to ColorDetail
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<ColorDetail> colorDetails;

	//bi-directional many-to-one association to DimensionDetail
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<DimensionDetail> dimensionDetails;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="material_id")
	private Material material;

	//bi-directional many-to-one association to ProductCategory
	@ManyToOne
	@JoinColumn(name="product_category_id")
	private ProductCategory productCategory;


}