package com.cn.cnpayment.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnpayment.dal.PaymentReviewDAL;
import com.cn.cnpayment.entity.PaymentReview;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;

import java.util.List;

@Service
public class PaymentReviewService {

// Autowire the PaymentReviewDAL object.
	@Autowired
	PaymentReviewDAL paymentReviewDAL;

	@Transactional
	public PaymentReview getPaymentReviewById(int id) {
		/**
		   1. This method fetches PaymentReview for a specific id.
		   2. If no paymentReview is found then it throws NotFoundException.
		**/
		PaymentReview paymentReview=paymentReviewDAL.getById(id);
		
		if(paymentReview==null)
			throw new NotFoundException("No paymentReview found with id:  "+id);
		
		return paymentReview;
	}

	@Transactional
	public List<PaymentReview> getAllPaymentReviews() {
		/**
		 1. This method fetches the list of all PaymentReviews.
		 2. If no paymentReview is found then it throws NotFoundException.
		 **/
		List<PaymentReview> paymentReview = paymentReviewDAL.getAllPaymentReview();
		
		if(paymentReview==null)
			throw new NotFoundException("No paymentReviews found.");
		
		return paymentReview;
	}

	@Transactional
	public void savePaymentReview(PaymentReview newPaymentReview) {
		/**
		 1. This method first checks if the given paymentReview exists or not.
		 2. If the given paymentReview is not found, then it saves the PaymentReview entity into the database.
		 3. If found then it throws ElementAlreadyExistException.
		 **/
		if(paymentReviewDAL.getById(newPaymentReview.getId())==null)
			paymentReviewDAL.save(newPaymentReview);
		else
			throw new ElementAlreadyExistException("Payment Review with given already exists");

	}

	@Transactional
	public void delete(int id) {
		/**
		 1. This method deletes PaymentReview for a specific id.
		 2. If no paymentReview is found for the given id, then it throws NotFoundException.
		 **/
		PaymentReview paymentReview = paymentReviewDAL.getById(id);
		if(paymentReview==null)
			throw new NotFoundException("No paymentReview found with id: " + id);
		else
			paymentReviewDAL.delete(id);

	}

	@Transactional
	public List<PaymentReview> getPaymentReviewByQueryType(String queryType){
		/**
		 1. This method fetches the list of PaymentReview based on the queryType received.
		 2. Passing an empty queryType throws InvalidInputException.
		 3. Only the following queryType are accepted in any format i.e. UpperCase/LowerCase
		        "Payment Issue","Bank Issue", "Merchant Issue"
		 **/
		List<PaymentReview> reviewsByQueryType = paymentReviewDAL.getByQueryType(queryType);
		
		if (reviewsByQueryType.isEmpty())
			throw new InvalidInputException("Invalid Query");
		
		return reviewsByQueryType;
	}

}
