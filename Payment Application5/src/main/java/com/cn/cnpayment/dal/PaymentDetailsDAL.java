package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.PaymentDetails;
import java.util.List;

public interface PaymentDetailsDAL {

	PaymentDetails getById(int id);

	void save(PaymentDetails paymentDetails);

	void delete(int id);

	List<PaymentDetails> getAllPaymentDetails();

    List<PaymentDetails> getByCurrency(String currency);

	void  update(PaymentDetails paymentDetails);
}
