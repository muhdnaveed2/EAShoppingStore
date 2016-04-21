/**
 * Author: Amit Bhanot
 */


package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ProductLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String productLineName;
	/*@OneToMany
	private List<Product> products = new ArrayList();
	
	@OneToMany
	private List<String> productCategories = new ArrayList();*/
	
	
	public String getProductLineName() {
		return productLineName;
	}
	public void setProductLineName(String productLineName) {
		this.productLineName = productLineName;
	}
	/*public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/*public List<String> getProductCategories() {
		return productCategories;
	}
	public void setProductCategories(List<String> productCategories) {
		this.productCategories = productCategories;
	}*/
}
