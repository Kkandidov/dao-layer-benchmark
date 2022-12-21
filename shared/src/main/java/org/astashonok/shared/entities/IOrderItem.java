package org.astashonok.shared.entities;

public interface IOrderItem extends IEntity {

	String getOrderId();
	void setOrderId(String orderId);
	String getProductId();
	void setProductId(String productId);
	Integer getNumber();
	void setNumber(Integer number);
}
