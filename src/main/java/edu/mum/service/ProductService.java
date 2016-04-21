package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;
import edu.mum.domain.ProductLine;

public interface ProductService {

	public void save(Product product);
	public Iterable<Product> getAllProducts();
//	public Iterable<ProductLine> getProductLines();
//	public List<String> getProductCategories(String productLine);
	public Product getProduct(long id);
}
