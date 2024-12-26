package Telecom.BillingService.service;

import Telecom.BillingService.dto.PaymentDto;
import Telecom.BillingService.model.Payment;
import Telecom.BillingService.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public void createPayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setAmount(paymentDto.getAmount());
        payment.setPayerEmail(paymentDto.getPayerEmail());
        paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment not found with ID: " + id));
    }

    public List<Payment> getPaymentsByInvoiceId(Long invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId);
    }

    public void updatePayment(Long id, PaymentDto paymentDto) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment not found with ID: " + id));

        existingPayment.setAmount(paymentDto.getAmount());
        existingPayment.setPaymentDate(paymentDto.getPaymentDate());
        existingPayment.setPaymentMethod(paymentDto.getPaymentMethod());
        existingPayment.setPayerEmail(paymentDto.getPayerEmail());

        paymentRepository.save(existingPayment);
    }

    public void deletePayment(Long id){
        paymentRepository.deleteById(id);
    }
}
