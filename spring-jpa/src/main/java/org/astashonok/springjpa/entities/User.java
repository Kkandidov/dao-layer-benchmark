package org.astashonok.springjpa.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User implements IUser {

	@Id
	private String id;
	private String name;
	private String email;

	@Column(name = "\"contactNumber\"")
	private String contactNumber;

	private String city;
	private String state;
	private String country;

	@Column(name = "\"postCode\"")
	private String postCode;
	private Boolean active;

	@Column(name = "\"execTime\"", insertable = false, updatable = false)
	private LocalDateTime execTime;

	public User() {
		this.id = UUID.randomUUID().toString();
	}
}
