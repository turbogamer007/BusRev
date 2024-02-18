package com.busRev.service;

import java.util.List;

import com.busRev.exception.BusException;
import com.busRev.exception.UserException;
import com.busRev.exception.FeedBackException;
import com.busRev.model.Feedback;


public interface FeedbackService {
	
	
	public Feedback addFeedBack(Feedback feedBack,Integer busId,String key) throws BusException, UserException;
	
	public Feedback updateFeedBack(Feedback feedback,String key) throws FeedBackException, UserException;
	
	public Feedback deleteFeedBack(Integer feedbackId, String key)throws FeedBackException,UserException;

	public Feedback viewFeedback(Integer id) throws FeedBackException;

	public List<Feedback> viewFeedbackAll() throws FeedBackException;
	
}
