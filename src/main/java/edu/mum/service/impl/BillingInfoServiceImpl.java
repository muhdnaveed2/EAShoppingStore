package edu.mum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.domain.BillingInfo;
import edu.mum.repository.BillingInfoRepository;
import edu.mum.service.BillingInfoService;

@Service
public class BillingInfoServiceImpl implements BillingInfoService {
	@Autowired
	private BillingInfoRepository billingInfoRepository;

	@Override
	public void save(BillingInfo billingInfo) {
		// TODO Auto-generated method stub
		billingInfoRepository.save(billingInfo);
	}

}
