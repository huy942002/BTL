package com.dangdao.shop.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.Date;

/**
 * The persistent class for the rder database table.
 * 
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQuery(name="Orders.findAll", query="SELECT r FROM Orders r")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String address;

	@JoinColumn(name="create_date")
	@Temporal(TemporalType.DATE)
	private Date createDate;

	private String fullname;


	private String sdt;

}