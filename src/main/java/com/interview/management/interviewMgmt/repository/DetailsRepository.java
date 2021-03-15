package com.interview.management.interviewMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.management.interviewMgmt.entity.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, String>  {

}
