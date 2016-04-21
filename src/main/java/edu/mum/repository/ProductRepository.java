package edu.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>
{
	/*@Query("select p.productCategory from Product p where productLine:productLine")
	public List<String> getProductCategories(@Param("productLine") String productLine);*/
}
