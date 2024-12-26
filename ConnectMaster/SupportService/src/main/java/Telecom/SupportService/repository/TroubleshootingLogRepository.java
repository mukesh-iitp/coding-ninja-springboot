package Telecom.SupportService.repository;

import Telecom.SupportService.model.TroubleshootingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TroubleshootingLogRepository extends JpaRepository<TroubleshootingLog, Long> {

    List<TroubleshootingLog> findByTicketId(Long ticketId);
}
