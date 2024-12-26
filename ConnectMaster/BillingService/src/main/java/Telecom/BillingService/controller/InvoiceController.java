package Telecom.BillingService.controller;

import Telecom.BillingService.dto.InvoiceDto;
import Telecom.BillingService.dto.ResponseMessage;
import Telecom.BillingService.model.Invoice;
import Telecom.BillingService.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createInvoice(@RequestBody InvoiceDto invoiceDto){
        invoiceService.createInvoice(invoiceDto);
        return new ResponseMessage("Invoice Created Successfully");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Invoice> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceById(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/{subscriptionId}")
    @ResponseStatus(HttpStatus.OK)
    public Invoice getInvoiceBySubscriptionId(@RequestParam Long subscriptionId){
        return invoiceService.getInvoiceBySubscriptionId(subscriptionId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updateInvoice(@PathVariable Long id, @RequestBody InvoiceDto invoiceDto) {
        invoiceService.updateInvoice(id, invoiceDto);
        return new ResponseMessage("Invoice Updated Successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return new ResponseMessage("Invoice Deleted Successfully");
    }
}

