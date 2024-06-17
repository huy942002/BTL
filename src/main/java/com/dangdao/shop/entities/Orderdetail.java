package com.dangdao.shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
/**
 * The persistent class for the orderdetail database table.
 * 
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="order_id")
	private Orders order;

	private double price;

	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	private int quantity;

	@ManyToOne
	@JoinColumn(name="dimension_id")
	private Dimension dimension;

	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;

	private int status;

}