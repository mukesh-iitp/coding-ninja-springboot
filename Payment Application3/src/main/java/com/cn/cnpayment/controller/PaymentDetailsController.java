package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cn.cnpayment.service.PaymentDetailsService;

import java.util.List;

/**
  In the PaymentDetailsController class complete the methods to handle HTTP requests with the required
 annotation for the following APIs:
 **/

@RestController
@RequestMapping("/details")
public class PaymentDetailsController {

    // Autowire the PaymentDetailsService object
	@Autowired
	PaymentDetailsService paymentDetailsService;


    // a. GET "/details/id/{id}": It fetches a payment detail by the given id. If a payment is not found by the
    //                            given id then this method throws NotFoundException
    @GetMapping("/id/{id}")
	public PaymentDetails getPaymentDetailsById(@PathVariable int id) {
        return paymentDetailsService.getPaymentDetailsById(id);
    }


    // b. POST "/details/save": It first checks whether the given PaymentDetails exist or not if found
    //                          then throws ElementAlreadyExistException and if not then saves the new PaymentDetails
    //                          into the database.
    @PostMapping("/save")
    public void savePaymentDetails(@RequestBody PaymentDetails paymentDetails) {
    	paymentDetailsService.savePaymentDetails(paymentDetails);
    }



    // c. DELETE "/details/id	/{id}": It deletes a PaymentDetails by the given id.
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable int id) {
    	paymentDetailsService.delete(id);

    }



    // d. PUT "/details/update" (Body - PaymentDetails object): It first checks for the given PaymentDetails object,
    //                                                          whether it exists in the database or not if found then updates the given entity else throws an NotFoundException.
    @PutMapping("/update")
    public void update(@RequestBody PaymentDetails paymentDetails) {
    	paymentDetailsService.update(paymentDetails);
    }


    // e. GET "/details/allPaymentDetails": It fetches the list of all PaymentDetails from the database. If the list is
    //                                      empty (If not data is found) then it returns NotFoundException.
    @GetMapping("/allPaymentDetails")
    public List<PaymentDetails> getAllPayments() {
        return paymentDetailsService.getAllPaymentDetails();
    }


    // f. GET "/details/currency/{currency}": It fetches the list of all PaymentDetails by the given currency.
    // Note: This API only accept the following currency in any format(Lowercase/Uppercase):
    // INR, Dollar, USD, Pound, Yen, Rupee
    // If currency other than the mentioned are passed then the api throws InvalidInputException with custom message.
    @GetMapping("/currency/{currency}")
    public List<PaymentDetails> getByCurrency(@PathVariable String currency) {
        return paymentDetailsService.getByCurrency(currency);
    }

}
