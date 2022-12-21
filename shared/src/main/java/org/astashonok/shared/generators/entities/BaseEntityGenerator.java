package org.astashonok.shared.generators.entities;

import org.astashonok.shared.generators.BooleanGenerator;
import org.astashonok.shared.generators.numbers.DoubleGenerator;
import org.astashonok.shared.generators.strings.ContactNumberGenerator;
import org.astashonok.shared.generators.strings.EmailGenerator;
import org.astashonok.shared.generators.strings.StringNumberGenerator;
import org.astashonok.shared.generators.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class BaseEntityGenerator<T> implements EntityGenerator<T> {

	protected final CategoryGenerator categoryGenerator = CategoryGenerator.getInstance();
	protected final BrandGenerator brandGenerator = BrandGenerator.getInstance();
	protected final ColorGenerator colorGenerator = ColorGenerator.getInstance();
	protected final DoubleGenerator doubleGenerator = DoubleGenerator.getInstance();
	protected final BooleanGenerator booleanGenerator = BooleanGenerator.getInstance();

	protected final NameGenerator nameGenerator = NameGenerator.getInstance();
	protected final EmailGenerator emailGenerator = EmailGenerator.getInstance();
	protected final ContactNumberGenerator contactNumberGenerator = ContactNumberGenerator.getInstance();
	protected final CityGenerator cityGenerator = CityGenerator.getInstance();
	protected final StateGenerator stateGenerator = StateGenerator.getInstance();
	protected final CountryGenerator countryGenerator = CountryGenerator.getInstance();
	protected final StringNumberGenerator stringNumberGenerator = StringNumberGenerator.getInstance();

	@Override
	public List<T> getRandomEntities(int capacity, Supplier<T> entityConstructor) {
		List<T> result = new ArrayList<>(capacity);

		for (int i = 0; i < capacity; i++) {
			result.add(getRandomEntity(entityConstructor));
		}

		return result;
	}
}
