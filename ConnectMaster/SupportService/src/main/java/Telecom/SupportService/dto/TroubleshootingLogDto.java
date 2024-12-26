package Telecom.SupportService.dto;

import Telecom.SupportService.model.Ticket;
import lombok.Data;

@Data
public class TroubleshootingLogDto {
    private Ticket ticket;
    private String logDetails;
    private String logDate;
}
