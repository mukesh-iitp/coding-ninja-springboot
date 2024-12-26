package Telecom.BillingService.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private Long invoiceId;
    private String paymentDate;
    private String amount;
    private String paymentMethod;
    private String payerEmail;
}
