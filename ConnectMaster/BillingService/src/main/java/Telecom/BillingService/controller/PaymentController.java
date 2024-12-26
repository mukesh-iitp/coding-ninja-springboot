package Telecom.BillingService.controller;

import Telecom.BillingService.dto.PaymentDto;
import Telecom.BillingService.dto.ResponseMessage;
import Telecom.BillingService.model.Payment;
import Telecom.BillingService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createPayment(@RequestBody PaymentDto paymentDto) {
        paymentService.createPayment(paymentDto);
        return new ResponseMessage("Payment done Successfully");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/{invoiceId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getPaymentsByInvoiceId(@RequestParam Long invoiceId) {
        return paymentService.getPaymentsByInvoiceId(invoiceId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto){
        paymentService.updatePayment(id, paymentDto);
        return new ResponseMessage("Payment Updated Successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deletePayment(@PathVariable Long id){
        paymentService.deletePayment(id);
        return new ResponseMessage("Payment Deleted Successfully");
    }
}
