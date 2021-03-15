package com.interview.management.interviewMgmt.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		List<Details> details = detailService.getDetailsList();
		//model.put("message", details.get(0));
		model.addAttribute("message",details.get(0));
		return "index";
	}
	
	/*@GetMapping("/landing")
	public ModelAndView landing() {
	    System.out.println("Inside landing method");
		List<Details> details = detailService.getDetailsList();
		ModelAndView mv = new ModelAndView();
		System.out.println(details.get(0));
		mv.addObject("obj", details.get(0));
		mv.setViewName("landing.jsp");
		return mv;
	}*/

	@ResponseBody
	@RequestMapping(value = "/senMail", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String senMail(@RequestBody Map<String,String> data, Model model) throws ParseException {
	    System.out.println("Inside senMail method"+ data);
	    Date date=new SimpleDateFormat("yyyy-MM-dd").parse(data.get("appDate")); 
	    Details details = new Details();
	    details.setName(data.get("name"));
	    details.setEmailId(data.get("emailId"));
	    details.setAppDate(date);
	    details.setMoveForward(data.get("moveForward"));
	    details.setInterviewTranscription(data.get("interviewTranscription"));
	    
		 
	    try {
			boolean status = callSendmail();
			if(status) {
				details.setActionResult("EmailSent");
			}
			else {
				details.setActionResult("EmailNotSent");
			}
			System.out.println("email status is: "+status);
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	    
	    Details updatedDetails = detailService.getUpdatedDetailsList(details, data.get("emailId"));
	    
		model.addAttribute("message",updatedDetails);
		
		return "index";
	   
	}
	
	public boolean callSendmail() throws AddressException, MessagingException, IOException {
		EmailSender emailSender = new EmailSender();
		//emailSender.sendmail();
		return true;   
	}

}
