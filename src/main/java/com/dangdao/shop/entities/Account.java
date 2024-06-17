package com.dangdao.shop.entities;


import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


/**
 * The persistent class for the account database table.
 * 
 */
@SuppressWarnings("serial")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "UserName is mandatory")
	private String username;

	@NotBlank(message = "FullName is mandatory")
	private String fullname;

	@NotBlank(message = "PassWord is mandatory")
	private String password;

	@NotBlank(message = "Role is mandatory")
	private String role;

}