package org.astashonok.springjdbc.entities;

import lombok.*;
import org.astashonok.shared.entities.IProduct;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product implements IProduct {

	private String id;
	private String category;
	private String brand;
	private String color;
	private Double size;
	private Double height;
	private Double width;
	private Double weight;
	private Double screen;
	private Double frontCamera;
	private Double realCamera;
	private Double capacity;
	private String displayTechnology;
	private String graphic;
	private Boolean active;
	private LocalDateTime execTime;

	public Product() {
		this.id = UUID.randomUUID().toString();
	}
}
