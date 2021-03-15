package com.interview.management.interviewMgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Details")
public class Details {
	
	@Id
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "AppointmentDate")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date appDate;
	
	@Column(name = "MoveForward")
	private String moveForward;
	
	@Column(name = "InterviewTranscription")
	private String interviewTranscription;
	
	@Column(name = "ActionResult")
	private String actionResult;
	
	
	public Details() {
		
	}

	public Details(String emailId, String name, Date appDate, String moveForward, String interviewTranscription,
			String actionResult) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.appDate = appDate;
		this.moveForward = moveForward;
		this.interviewTranscription = interviewTranscription;
		this.actionResult = actionResult;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public String getMoveForward() {
		return moveForward;
	}

	public void setMoveForward(String moveForward) {
		this.moveForward = moveForward;
	}

	public String getInterviewTranscription() {
		return interviewTranscription;
	}

	public void setInterviewTranscription(String interviewTranscription) {
		this.interviewTranscription = interviewTranscription;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	@Override
	public String toString() {
		return "Details [emailId=" + emailId + ", name=" + name + ", appDate=" + appDate + ", moveForward="
				+ moveForward + ", interviewTranscription=" + interviewTranscription + ", actionResult=" + actionResult
				+ "]";
	}
	
}
