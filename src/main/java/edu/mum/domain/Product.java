/**
 * Author: Amit Bhanot
 */


package edu.mum.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message="Product.name.NotEmpty")
	private String name;
	/*@OneToMany
	private List<ProductStock> stocks = new ArrayList<ProductStock>();*/
	@Min(value=0,message="Product.stock.min")
	private int stock;
	@Min(value=0,message="Product.price.min")
	private double price;
	@NotEmpty(message="Product.brandName.NotEmpty")
	private String brandName;
//	@Valid
//	@OneToOne
//	private ProductLine productLine;
	@NotEmpty(message="Product.productLine.NotEmpty")
	private String productLine;
	@NotEmpty(message="Product.productCategory.NotEmpty")
	private String productCategory;
	
	
/*	@Lob
	private byte[] productImage;
	
	private String productImageName;*/
	
	@JsonIgnore
	@Transient
	private MultipartFile  productImage;
	
	@Enumerated(EnumType.STRING)
	private GenderLine genderLine;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*public List<ProductStock> getStocks() {
		return stocks;
	}
	public void setStocks(List<ProductStock> stocks) {
		this.stocks = stocks;
	}*/
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/*public ProductLine getProductLine() {
		return productLine;
	}
	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}*/
	/*public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}*/
	public GenderLine getGenderLine() {
		return genderLine;
	}
	public void setGenderLine(GenderLine genderLine) {
		this.genderLine = genderLine;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	/*public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}*/
	/*public String getProductImageName() {
		return productImageName;
	}
	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}*/
}
