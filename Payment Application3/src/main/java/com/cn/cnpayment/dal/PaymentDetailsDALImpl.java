package com.cn.cnpayment.dal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.entity.PaymentDetails;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.persistence.EntityManager;

/**
 # Complete the PaymentDetailsDALImpl class as mentioned below:

 	a. Autowire EntityManager.

 	b. Override the following methods:

 		1. getById(int id): This method fetches PaymentDetails for a specific id from the database.

	 	2. getAllPaymentDetails(): This method fetches the list of PaymentDetails from the database.

	 	3. save(PaymentDetails paymentDetails): This method saves the PaymentDetails entity into the database.

	 	4. delete(int id): This method deletes the PaymentDetails entity for a specific id.

	 	5. update(PaymentDetails paymentDetails): This method updates paymentDetails.

	 	6. getByCurrency(String currency): This method fetches the list of PaymentDetails from the database for
                                           a specific currency.
 **/


@Repository
public class PaymentDetailsDALImpl implements PaymentDetailsDAL {

	// Auto-wire the EntityManager object
	@Autowired
	EntityManager entityManager;

	@Override
	public PaymentDetails getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		return paymentDetails;
	}

	@Override
	public void save(PaymentDetails paymentDetails) {
		Session session = entityManager.unwrap(Session.class);
		session.save(paymentDetails);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails = session.get(PaymentDetails.class, id);
		if (paymentDetails==null)
			throw new NotFoundException("PaymentDetails with given id does not exists");
		
		session.delete(paymentDetails);
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		Session session = entityManager.unwrap(Session.class);
		List<PaymentDetails> allPaymentDetails = session.createQuery(
				"SELECT p FROM PaymentDetails p", PaymentDetails.class).getResultList();
		return allPaymentDetails;
	}

	@Override
	public void update(PaymentDetails paymentDetails) {
		Session session = entityManager.unwrap(Session.class);
		PaymentDetails paymentDetails1=getById(paymentDetails.getId());
		if (paymentDetails!=null){
			paymentDetails1.setAmount(paymentDetails.getAmount());
			paymentDetails1.setCurrency(paymentDetails.getCurrency());
			paymentDetails1.setCreditAccount(paymentDetails.getCreditAccount());
			paymentDetails1.setDebitAccount(paymentDetails.getDebitAccount());
			session.update(paymentDetails1);
		}
		else
			throw new NotFoundException("PaymentDetails with given id does not exists");


	}

	@Override
	public List<PaymentDetails> getByCurrency(String currency) {
		List<PaymentDetails> allPaymentsDetails=getAllPaymentDetails();
		List<PaymentDetails> paymentsByCurrency = new ArrayList<>();
		for(PaymentDetails paymentDetails : allPaymentsDetails){
			if(paymentDetails.getCurrency().equalsIgnoreCase(currency)){
				paymentsByCurrency.add(paymentDetails);
			}
		}
		return paymentsByCurrency;

	}




}
