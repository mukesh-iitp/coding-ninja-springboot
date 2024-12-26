package Telecom.SupportService.service;

import Telecom.SupportService.dto.MaintenanceScheduleDto;
import Telecom.SupportService.exception.InternalServerError;
import Telecom.SupportService.exception.NotFoundException;
import Telecom.SupportService.model.MaintenanceSchedule;
import Telecom.SupportService.repository.MaintenanceScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MaintenanceScheduleService {

    @Autowired
    MaintenanceScheduleRepository maintenanceScheduleRepository;

    public void createMaintenanceSchedule(MaintenanceScheduleDto maintenanceScheduleDto){
        MaintenanceSchedule maintenanceSchedule = new MaintenanceSchedule();
        maintenanceSchedule.setDescription(maintenanceScheduleDto.getDescription());
        maintenanceSchedule.setStatus(maintenanceScheduleDto.getStatus());
        maintenanceSchedule.setStartDate(maintenanceScheduleDto.getStartDate());
        maintenanceSchedule.setEndDate(maintenanceScheduleDto.getEndDate());
        maintenanceScheduleRepository.save(maintenanceSchedule);
    }

    public List<MaintenanceSchedule> getAllMaintenanceSchedules(){
        return maintenanceScheduleRepository.findAll();
    }

    public MaintenanceSchedule getMaintenanceScheduleById(Long id){
        return maintenanceScheduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Maintenance Schedule Not found with id: "+ id));
    }

    public void updateMaintenanceSchedule(Long id, MaintenanceScheduleDto maintenanceScheduleDto) {
        MaintenanceSchedule existingmaintenanceSchedule = maintenanceScheduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Maintenance Schedule Not found with id: "+ id));
        existingmaintenanceSchedule.setEndDate(maintenanceScheduleDto.getEndDate());
        existingmaintenanceSchedule.setStartDate(maintenanceScheduleDto.getStartDate());
        existingmaintenanceSchedule.setStatus(maintenanceScheduleDto.getStatus());
        existingmaintenanceSchedule.setDescription(maintenanceScheduleDto.getDescription());
        maintenanceScheduleRepository.save(existingmaintenanceSchedule);
    }

    public void deleteMaintenanceSchedule(Long id){
        maintenanceScheduleRepository.deleteById(id);
    }

}
