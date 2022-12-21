package org.astashonok.shared.generators.entities;

import org.astashonok.shared.entities.IUser;

import java.util.function.Supplier;

public class UserGenerator<U extends IUser> extends BaseEntityGenerator<U> {

	@Override
	public U getRandomEntity(Supplier<U> entityConstructor) {
		U user = entityConstructor.get();

		user.setName(nameGenerator.getRandomValue());
		user.setEmail(emailGenerator.getRandomValue());
		user.setContactNumber(contactNumberGenerator.getRandomValue());
		user.setCity(cityGenerator.getRandomValue());
		user.setState(stateGenerator.getRandomValue());
		user.setCountry(countryGenerator.getRandomValue());
		user.setPostCode(stringNumberGenerator.getRandomValue());
		user.setActive(booleanGenerator.getRandomValue());

		return user;
	}
}
