package Telecom.SupportService.dto;

import lombok.Data;

@Data
public class MaintenanceScheduleDto {
    private String description;
    private String startDate;
    private String endDate;
    private String status;

}
