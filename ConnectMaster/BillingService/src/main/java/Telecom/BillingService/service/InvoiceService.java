package Telecom.BillingService.service;

import Telecom.BillingService.dto.InvoiceDto;
import Telecom.BillingService.model.Invoice;
import Telecom.BillingService.model.Payment;
import Telecom.BillingService.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void createInvoice(InvoiceDto invoiceDto){
        Invoice invoice = new Invoice();
        invoice.setSubscriptionId(invoiceDto.getSubscriptionId());
        invoice.setCustomerName(invoiceDto.getCustomerName());
        invoice.setInvoiceDate(invoiceDto.getInvoiceDate());
        invoice.setAmount(invoiceDto.getAmount());
        if(invoiceDto.getPaymentList() != null) {
            for (Payment payment : invoiceDto.getPaymentList()) {
                payment.setInvoice(invoice);
            }
        }
        invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with ID: " + id));
    }

    public Invoice getInvoiceBySubscriptionId(Long subscriptionId){
        return invoiceRepository.findBySubscriptionId(subscriptionId);
    }

    public void updateInvoice(Long id, InvoiceDto invoiceDto){
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with ID: " + id));

        existingInvoice.setCustomerName(invoiceDto.getCustomerName());
        existingInvoice.setInvoiceDate(invoiceDto.getInvoiceDate());
        existingInvoice.setAmount(invoiceDto.getAmount());
        existingInvoice.setSubscriptionId(invoiceDto.getSubscriptionId());
        invoiceRepository.save(existingInvoice);
    }

    public void deleteInvoice(Long id){
        invoiceRepository.deleteById(id);
    }

}
