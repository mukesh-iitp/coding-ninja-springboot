package Telecom.BillingService.dto;


import Telecom.BillingService.model.Payment;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class InvoiceDto {
    private Long subscriptionId;
    private String customerName;
    private String invoiceDate;
    private Integer amount;
    private List<Payment> paymentList;
}
