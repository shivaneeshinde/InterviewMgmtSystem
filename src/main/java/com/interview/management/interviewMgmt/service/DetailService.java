package com.interview.management.interviewMgmt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.interview.management.interviewMgmt.entity.Details;
import com.interview.management.interviewMgmt.repository.DetailsRepository;

@Service
@Transactional
public class DetailService {
	private final DetailsRepository detailsRepository;

	public DetailService(DetailsRepository detailsRepository) {
		super();
		this.detailsRepository = detailsRepository;
	}
	
	public List<Details> getDetailsList() {
	    System.out.println("Inside empList method");	    
		return this.detailsRepository.findAll();
	}

}
