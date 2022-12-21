package org.astashonok.springjdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IUser;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class User implements IUser {

	private String id;
	private String name;
	private String email;
	private String contactNumber;
	private String city;
	private String state;
	private String country;
	private String postCode;
	private Boolean active;
	private LocalDateTime execTime;

	public User() {
		this.id = UUID.randomUUID().toString();
	}
}
