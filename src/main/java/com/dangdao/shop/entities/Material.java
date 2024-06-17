package com.dangdao.shop.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;


import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the materials database table.
 * 
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="materials")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="materials_id")
	private int materialsId;

	@Column(name="material_name")
	@NotBlank(message = "Tên vật liệu không để trống")
	private String materialName;

	@NotNull(message = "Giá tiền không để trống")
	@PositiveOrZero(message = "Giá tiền không âm")
	private double price;

	//bi-directional many-to-one association to MaterialCategory
	@ManyToOne
	@JoinColumn(name="material_category_id")
	private MaterialCategory materialCategory;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="material")
	private List<Product> products;
}