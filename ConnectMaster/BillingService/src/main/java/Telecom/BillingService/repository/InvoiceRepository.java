package Telecom.BillingService.repository;

import Telecom.BillingService.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findBySubscriptionId(Long subscriptionId);
}
