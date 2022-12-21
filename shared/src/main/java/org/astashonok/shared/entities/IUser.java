package org.astashonok.shared.entities;

public interface IUser extends IEntity {

	String getName();
	void setName(String name);
	String getEmail();
	void setEmail(String email);
	String getContactNumber();
	void setContactNumber(String contactNumber);
	String getCity();
	void setCity(String city);
	String getState();
	void setState(String state);
	String getCountry();
	void setCountry(String country);
	String getPostCode();
	void setPostCode(String postcode);
}
