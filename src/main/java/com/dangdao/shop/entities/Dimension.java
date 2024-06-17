package com.dangdao.shop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
/**
 * The persistent class for the dimensions database table.
 * 
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="dimensions")
@NamedQuery(name="Dimension.findAll", query="SELECT d FROM Dimension d")
public class Dimension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Kích Thước không để trống!")
	private String size;

}