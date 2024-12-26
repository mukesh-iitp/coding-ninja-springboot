package Telecom.SupportService.service;

import Telecom.SupportService.dto.TicketDto;
import Telecom.SupportService.model.Ticket;
import Telecom.SupportService.model.TroubleshootingLog;
import Telecom.SupportService.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class TicketService {

    @Autowired
    private TicketRepository ticketrepository;

    public void createTicket(TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setStatus(ticketDto.getStatus());
        ticket.setCreationDate(ticketDto.getCreationDate());
        ticket.setPriority(ticketDto.getPriority());
        ticket.setUserId(ticketDto.getUserId());
        ticket.setIssueDescription(ticketDto.getIssueDescription());
        ticket.setResolutionDate(ticketDto.getResolutionDate());
        for(TroubleshootingLog troubleshootingLog : ticketDto.getTroubleshootingLogList()){
            troubleshootingLog.setTicket(ticket);
        }
        ticketrepository.save(ticket);
    }

    public List<Ticket> getAllTickets(){
        return ticketrepository.findAll();
    }

    public Ticket getTicketById(Long id){
        return ticketrepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Ticket not found with id: "+ id));
    }

    public List<Ticket> getTicketByUserId(Long userId){
        return ticketrepository.findByUserId(userId);
    }

    public void updateTicket(Long id, TicketDto ticketDto) {
        Ticket existingTicket = ticketrepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Maintenance Schedule Not found with id: "+ id));
        existingTicket.setStatus(ticketDto.getStatus());
        existingTicket.setCreationDate(ticketDto.getCreationDate());
        existingTicket.setPriority(ticketDto.getPriority());
        existingTicket.setUserId(ticketDto.getUserId());
        existingTicket.setIssueDescription(ticketDto.getIssueDescription());
        existingTicket.setResolutionDate(ticketDto.getResolutionDate());
        for(TroubleshootingLog troubleshootingLog : ticketDto.getTroubleshootingLogList()){
            troubleshootingLog.setTicket(existingTicket);
        }
        ticketrepository.save(existingTicket);
    }

    public void deleteTicket(Long id){
        ticketrepository.deleteById(id);
    }
    
}
