package org.astashonok.shared.entities;

public interface IProduct extends IEntity {

	String getCategory();
	void setCategory(String type);
	String getBrand();
	void setBrand(String brand);
	String getColor();
	void setColor(String color);
	Double getSize();
	void setSize(Double size);
	Double getHeight();
	void setHeight(Double height);
	Double getWidth();
	void setWidth(Double width);
	Double getWeight();
	void setWeight(Double weight);
	Double getScreen();
	void setScreen(Double screen);
	Double getFrontCamera();
	void setFrontCamera(Double frontCamera);
	Double getRealCamera();
	void setRealCamera(Double realCamera);
	Double getCapacity();
	void setCapacity(Double capacity);
	String getDisplayTechnology();
	void setDisplayTechnology(String displayTechnology);

	String getGraphic();

	void setGraphic(String graphic);
}
