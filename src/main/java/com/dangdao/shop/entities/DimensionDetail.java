package com.dangdao.shop.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
/**
 * The persistent class for the dimension_details database table.
 * 
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="dimension_details")
@NamedQuery(name="DimensionDetail.findAll", query="SELECT d FROM DimensionDetail d")
public class DimensionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JoinColumn(name="price")

	@NotNull(message = "Tiền Không để trống!")
	@PositiveOrZero(message = "Tiền không âm!")
	private double price;

	//bi-directional many-to-one association to Dimension
	@ManyToOne
	@JoinColumn(name="dimension_id")
	private Dimension dimension;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;


}