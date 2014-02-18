package com.learn.hibernate.annotations;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//Creates table with whatever name given here with 'name' property instead of treating the class name as the table name, by default.
@Entity
@Table(name = "USER_DETAILS")
// We can give the table name separately from entity name. By doing this we
// specified the table name and the entity name will be set to default. This
// will be helpful when using HQL.
public class User {
	// @Id
	// @Column(name="USER_ID")
	private long id;

	// @Column(name="USER_NAME")
	// The @Basic treat it as a field that need to be persisted and apply
	// hibernate's defaults. Even without this, hibernate does the same. But by
	// using it, we were telling hibernate to go as it is. We need to provide
	// couple of other properties fetch and optional. These are the reason why
	// we need to specify @Basic. otherwise it is as good as not declaring
	// @Basic. We'll discuss these later.
	// @Basic
	private String name;

	private Date joinDate;
	private String address;
	private String description;

	// We can provide the annotations on top of getters as well instead of on
	// the fields.
	// with this configuration, it will insert with whatever value the getter
	// method returns.
	@Id @GeneratedValue(strategy = GenerationType.AUTO) //@GeneratedValue is used to tell hibernate to generate a primary or surrogate key
	@Column(name = "USER_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "USER_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @Temporal is used to specify the type of the field explicitly instead of
	 *           hibernate to use the default corresponding type.
	 * 
	 * @return
	 */
	@Temporal(TemporalType.DATE)
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	// If we want hibernate not store a specific property even though we have
	// set the value for the property, we use @Transient. If we have any
	// @Transient properties, hibernate by default will not store that property.

	// Note: All Hibernate annotations, including @Transient must be applied
	// according to access type. By default it will be the same way as @Id
	// applied. That is if you place @Id on a field you must apply @Transient to
	// the field. And if you apply @Id to getter method, you must apply
	// @Transient method. Setter methods are always ignored.
	// @Transient
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Lob means large object. there are 2 types: blob, or clob. Using this we
	 * can specify hibernate to define the field as LOB, instead of declaring it
	 * as varchar with 255 limit.
	 * 
	 * @return
	 */
	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
