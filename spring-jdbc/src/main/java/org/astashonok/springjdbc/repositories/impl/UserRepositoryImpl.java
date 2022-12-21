package org.astashonok.springjdbc.repositories.impl;

import org.astashonok.springjdbc.entities.User;
import org.astashonok.springjdbc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private static final String INSERT_USER_QUERY = "INSERT INTO \"user\"(id, name, email, \"contactNumber\", city, "
			+ "state, country, \"postCode\", active)\n"
			+ "VALUES(?,?,?,?,?,?,?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(User entity) {
		return jdbcTemplate.update(INSERT_USER_QUERY, entity.getId(), entity.getName(), entity.getEmail(),
				entity.getContactNumber(), entity.getCity(), entity.getState(), entity.getCountry(),
				entity.getPostCode(), entity.getActive());
	}
}
