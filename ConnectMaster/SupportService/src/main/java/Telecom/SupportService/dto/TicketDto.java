package Telecom.SupportService.dto;

import Telecom.SupportService.model.TroubleshootingLog;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long userId;
    private String issueDescription;
    private String priority;
    private String status;
    private String creationDate;
    private String resolutionDate;
    List<TroubleshootingLog> troubleshootingLogList = new ArrayList<>();
}
