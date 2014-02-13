package com.learn.hibernate.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DETAILS") //Creates table with whatever name given here with 'name' property instead of treating the class name as the table name, by default.
public class User {
//	@Id
//	@Column(name="USER_ID")
	private long id;
	
//	@Column(name="USER_NAME")
	private String name;

	// We can provide the annotations on top of getters as well instead of on the fields.
	// with this configuration, it will insert with whatever value the getter method returns.
	@Id
	@Column(name="USER_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="USER_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
