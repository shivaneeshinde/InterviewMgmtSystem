package com.interview.management.interviewMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.interview.management.interviewMgmt.entity.Details;
import com.interview.management.interviewMgmt.service.DetailService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	
	@Autowired
	private DetailService detailService;
	
	@GetMapping("/healthCheck")
	public String check()
	{
		return "checked";
	}
	
	@GetMapping("/detailsList")
	public Details detailsList() {
	    System.out.println("Inside detailsList method");
		List<Details> details = detailService.getDetailsList();
		return details.get(0);
	}

}
