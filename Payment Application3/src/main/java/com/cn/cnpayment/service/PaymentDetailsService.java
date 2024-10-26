package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.PaymentDetailsDAL;
import com.cn.cnpayment.entity.PaymentDetails;
import com.cn.cnpayment.exception.ElementAlreadyExistException;
import com.cn.cnpayment.exception.InvalidInputException;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDetailsService {

	// Auto-wire the PaymentDetailsDAL object
	@Autowired
	PaymentDetailsDAL paymentDetailsDAL;


	@Transactional
	public PaymentDetails getPaymentDetailsById(int id) {
		// 1. This method fetches PaymentDetails for the given id.
		// 2. If no paymentDetails is found by the given id then it throws NotFoundException with custom message.
		PaymentDetails paymentDetails = paymentDetailsDAL.getById(id);
		if (paymentDetails == null) {
			throw new NotFoundException("No paymentDetails found with id:  " + id);
		}
		return paymentDetails;
	}

	@Transactional
	public List<PaymentDetails> getAllPaymentDetails() {
		// 1. This method fetches the list of all PaymentDetails from the database.
		// 2. If the no paymentDetails data is found then it throws NotFoundException with custom message.
		List<PaymentDetails> paymentDetails = paymentDetailsDAL.getAllPaymentDetails();
		if (paymentDetails == null) {
			throw new NotFoundException("No paymentDetails found.");
		}
		return paymentDetails;

	}

	@Transactional
	public void savePaymentDetails(PaymentDetails newPaymentDetails) {
		// 1. It first checks whether the given paymentDetails object exists in the database or not.
		// 2. If the given paymentDetails already exist in the database, then it throws ElementAlreadyExistException.
		// 3. If the given paymentDetails doesn't exist, it saves the new PaymentDetails into the database.
		List<PaymentDetails> allPaymentDetails = getAllPaymentDetails();
		for (PaymentDetails paymentDetails : allPaymentDetails) {
			if (paymentDetails.getId() == newPaymentDetails.getId()) {
				throw new ElementAlreadyExistException("This paymentDetails already exist.");
			}
		}
		paymentDetailsDAL.save(newPaymentDetails);

	}

	@Transactional
	public void delete(int id) {
		// 1. It deletes a paymentDetails for the given id from the database.
		paymentDetailsDAL.delete(id);
	}

	
	@Transactional
	public void update(PaymentDetails paymentDetails) {
		// 1. It first checks if the given paymentDetails exists in the database or not.
		// 2. If the given paymentDetails object exists in the database, then it is simply updated.
		// 3. If not found, then it throws NotFoundException with custom message.
		if (getPaymentDetailsById(paymentDetails.getId()) != null)
			paymentDetailsDAL.update(paymentDetails);
		else {
			throw new NotFoundException("PaymentDetails with given id not found");
		}

	}

	@Transactional
	public List<PaymentDetails> getByCurrency(String currency) {
		// 1. It fetches the list of all PaymentDetails from the database for the given id.
		// 2. It supports the following given currency only with any format i.e. UpperCase/LoweCase:
		// 3. "INR", "Rupee", "Dollar", "Yen", "Pound", "USD"
		// 4. It throws InvalidInputException if a currency different from the mentioned above is passed.
		if (currency.equalsIgnoreCase("INR") || currency.equalsIgnoreCase("Rupee")
				|| currency.equals("Dollar") || currency.equals("Yen") || currency.equals("Pound")
				|| currency.equals("USD")) {
			return paymentDetailsDAL.getByCurrency(currency);
		} else {
			throw new InvalidInputException("Invalid Currency");
		}

	}
}
