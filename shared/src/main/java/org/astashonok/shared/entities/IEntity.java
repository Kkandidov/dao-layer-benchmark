package org.astashonok.shared.entities;

import java.time.LocalDateTime;

public interface IEntity {

	String getId();
	void setId(String id);
	Boolean getActive();
	void setActive(Boolean active);
	LocalDateTime getExecTime();
}
