package com.dangdao.shop.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="banner")
@NamedQuery(name="Banner.findAll", query="SELECT c FROM Banner c")
public class Banner implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="title")
	@NotBlank(message = "Title Không để trống")
	private String title;

	@NotBlank(message = "Image Không để trống")
	private String image;

	@NotBlank(message = "URL Không để trống")
    private String url;

	private boolean state; 
}
