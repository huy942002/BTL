package com.dangdao.shop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the material_category database table.
 * 
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="material_category")
@NamedQuery(name="MaterialCategory.findAll", query="SELECT m FROM MaterialCategory m")
public class MaterialCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="material_category_name")
	@NotBlank(message = "Tên thể loại vật liệu Không để trống")
	private String materialCategoryName;

	//bi-directional many-to-one association to Material
	@JsonIgnore
	@OneToMany(mappedBy="materialCategory")
	private List<Material> materials;


}