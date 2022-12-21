package org.astashonok.shared.entities;

import java.util.List;

public interface IOrder<IO extends IEntity> extends IEntity {

	String getUserId();
	void setUserId(String userId);
	List<IO> getOrderItems();
	void setOrderItems(List<IO> orderItems);
}
