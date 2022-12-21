package org.astashonok.springjdbc.mappers;

import org.astashonok.springjdbc.entities.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Configuration
public class BeanMappers {

	@Bean
	public BeanPropertyRowMapper<Product> productMapper() {
		return BeanPropertyRowMapper.newInstance(Product.class);
	}
}
