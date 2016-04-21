package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.domain.ProductLine;

public interface ProductLineRepository extends CrudRepository<ProductLine, Long> {

}
