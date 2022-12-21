package org.astashonok.shared.generators.entities;

import org.astashonok.shared.entities.IProduct;
import org.astashonok.shared.generators.types.DisplayTechnologyGenerator;
import org.astashonok.shared.generators.types.GraphicGenerator;

import java.util.function.Supplier;

public class ProductGenerator<P extends IProduct> extends BaseEntityGenerator<P> {

	private DisplayTechnologyGenerator displayTechnologyGenerator = DisplayTechnologyGenerator.getInstance();
	private GraphicGenerator graphicGenerator = GraphicGenerator.getInstance();

	@Override
	public P getRandomEntity(Supplier<P> entityConstructor) {
		P product = entityConstructor.get();

		product.setCategory(categoryGenerator.getRandomValue());
		product.setBrand(brandGenerator.getRandomValue());
		product.setColor(colorGenerator.getRandomValue());
		product.setSize(doubleGenerator.getValue(3.0, 10.0));
		product.setHeight(doubleGenerator.getValue(10.0, 20.0));
		product.setWidth(doubleGenerator.getValue(10.0, 20.0));
		product.setWeight(doubleGenerator.getValue(100.0, 200.0));
		product.setScreen(doubleGenerator.getValue(10.0, 20.0));
		product.setFrontCamera(doubleGenerator.getValue(10.0, 20.0));
		product.setRealCamera(doubleGenerator.getValue(10.0, 50.0));
		product.setCapacity(doubleGenerator.getValue(3000.0, 8000.0));
		product.setDisplayTechnology(displayTechnologyGenerator.getRandomValue());
		product.setGraphic(graphicGenerator.getRandomValue());
		product.setActive(booleanGenerator.getRandomValue());

		return product;
	}
}
