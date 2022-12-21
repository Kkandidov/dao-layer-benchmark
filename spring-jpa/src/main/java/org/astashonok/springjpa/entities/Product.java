package org.astashonok.springjpa.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "product", schema = "public")
public class Product implements IProduct {

	@Id
	private String id;
	private String category;
	private String brand;
	private String color;
	private Double size;
	private Double height;
	private Double width;
	private Double weight;
	private Double screen;

	@Column(name = "\"frontCamera\"")
	private Double frontCamera;

	@Column(name = "\"realCamera\"")
	private Double realCamera;

	private Double capacity;

	@Column(name = "\"displayTechnology\"")
	private String displayTechnology;

	private String graphic;
	private Boolean active;

	@Column(name = "\"execTime\"", insertable = false, updatable = false)
	private LocalDateTime execTime;

	public Product() {
		this.id = UUID.randomUUID().toString();
	}
}
