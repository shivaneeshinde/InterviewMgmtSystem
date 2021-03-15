package com.interview.management.interviewMgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interview.management.interviewMgmt.entity.Details;
import com.interview.management.interviewMgmt.service.DetailService;

//@org.springframework.web.bind.annotation.RestController
@Controller
public class RestController {
	
	
	@Autowired
	private DetailService detailService;

	@ResponseBody
	@GetMapping("/healthCheck")
	public String check()
	{
		return "checked";
	}
	
	@ResponseBody
	@GetMapping("/detailsList")
	public Details detailsList() {
	    System.out.println("Inside detailsList method");
		List<Details> details = detailService.getDetailsList();
		return details.get(0);
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("message", "hey there");
		return "index";
	}

}
