/**
 * Author: Amit Bhanot
 */

package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="Customer.name.NotEmpty")
	private String name;
//	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private Address billingAddress;
//	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private Address shippingAddress;
//	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private BillingInfo billingInfo;
//	@Valid
	@OneToOne(cascade=CascadeType.ALL)
	private ContactNumber contactNumber;
	@Email(message="Customer.email.NotEmpty")
	private String email;
//	@NotEmpty(message="Customer.gender.NotEmpty")
//	private String gender;
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<ShoppingOrder> orders = new ArrayList();
	
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="USERNAME") 
	private Credentials credentials;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingInfo getBillingInfo() {
		return billingInfo;
	}
	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}
	public ContactNumber getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(ContactNumber contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
/*	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}*/
	public List<ShoppingOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<ShoppingOrder> orders) {
		this.orders = orders;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public boolean addShoppingOrder(ShoppingOrder shoppingOrder) {
		return orders.add(shoppingOrder);
	}
	public boolean removeShoppingOrder(ShoppingOrder shoppingOrder) {
		return orders.remove(shoppingOrder);
	}
}
