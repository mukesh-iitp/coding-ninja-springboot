package Telecom.SupportService.service;

import Telecom.SupportService.dto.TroubleshootingLogDto;
import Telecom.SupportService.model.TroubleshootingLog;
import Telecom.SupportService.repository.TroubleshootingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TroubleshootingLogService {

    @Autowired
    private TroubleshootingLogRepository troubleshootingLogRepository;
    
    public void createTroubleshootingLog(TroubleshootingLogDto troubleshootingLogDto){
        TroubleshootingLog troubleshootingLog = new TroubleshootingLog();
        troubleshootingLog.setTicket(troubleshootingLogDto.getTicket());
        troubleshootingLog.setLogDate(troubleshootingLog.getLogDetails());
        troubleshootingLog.setLogDetails(troubleshootingLog.getLogDetails());
        troubleshootingLogRepository.save(troubleshootingLog);
    }

    public List<TroubleshootingLog> getAllTroubleshootingLogs(){
        return troubleshootingLogRepository.findAll();
    }

    public TroubleshootingLog getTroubleshootingLogById(Long id){
        return troubleshootingLogRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TroubleshootingLog not found with id: "+ id));
    }

    public  List<TroubleshootingLog> getTroubleshootingLogByTicketId(Long ticketId){
        return troubleshootingLogRepository.findByTicketId(ticketId);
    }

    public void updateTroubleshootingLog(Long id, TroubleshootingLogDto troubleshootingLogDto) {
        TroubleshootingLog existingTroubleshootingLog = troubleshootingLogRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TroubleshootingLog not found with id: "+ id));
        existingTroubleshootingLog.setTicket(troubleshootingLogDto.getTicket());
        existingTroubleshootingLog.setLogDate(troubleshootingLogDto.getLogDetails());
        existingTroubleshootingLog.setLogDetails(troubleshootingLogDto.getLogDetails());
        troubleshootingLogRepository.save(existingTroubleshootingLog);
    }

    public void deleteTroubleshootingLog(Long id){
        troubleshootingLogRepository.deleteById(id);
    }


}
