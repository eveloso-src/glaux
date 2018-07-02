package com.formapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "email")
	@Email(message = "*Por favor, ingresar Email valido")
	@NotEmpty(message = "*Por favor, ingresar email")
	private String email;
	
	
	@Column(name = "name")
	@NotEmpty(message = "*Por favor, ingresar nombre")
	private String name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "*Por favor, ingresar apellido")
	private String lastName;
	

	@Column(name = "tel")
	@NotEmpty(message = "*Por favor, ingresar telefono")
	private String tel;


	@Column(name = "job")
	@NotEmpty(message = "*Por favor, ingresar ocupacion")
	private String job;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	
}
