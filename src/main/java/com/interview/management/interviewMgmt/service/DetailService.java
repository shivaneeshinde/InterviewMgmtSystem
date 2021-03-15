package com.interview.management.interviewMgmt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.interview.management.interviewMgmt.entity.Details;
import com.interview.management.interviewMgmt.repository.DetailsRepository;

@Service
@Transactional
public class DetailService {
	private final DetailsRepository detailsRepository;

	public DetailService(DetailsRepository detailsRepository) {
		this.detailsRepository = detailsRepository;
	}
	
	public List<Details> getDetailsList() {
	    System.out.println("Inside empList method");	    
		return this.detailsRepository.findAll();
	}
	
	public Details getUpdatedDetailsList(Details details, String emailId) {
		detailsRepository.save(details);
		Optional<Details> details1 = detailsRepository.findById(emailId);
		if(details1.isPresent()) {
			return details1.get();
		}
		else {
			return null;
		}
	}

}
