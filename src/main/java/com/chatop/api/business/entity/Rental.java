package com.chatop.api.business.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double surface;
	
	private Double price;
	
	private String picture;

	@Column(length = 2000)
	private String description;
	
	@Column(name="owner_id")
	private Integer ownerId;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
}