package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.domain.BillingInfo;

public interface BillingInfoRepository extends CrudRepository<BillingInfo, Long> {

}
