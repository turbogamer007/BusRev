package com.busRev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busRev.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{
	
}
