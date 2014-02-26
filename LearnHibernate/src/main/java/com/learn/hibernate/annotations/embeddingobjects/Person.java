package com.learn.hibernate.annotations.embeddingobjects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
	@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
	@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
	@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE"))})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
}
