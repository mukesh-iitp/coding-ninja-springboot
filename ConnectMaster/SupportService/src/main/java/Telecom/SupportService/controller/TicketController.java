package Telecom.SupportService.controller;

import Telecom.SupportService.dto.TicketDto;
import Telecom.SupportService.dto.ResponseMessage;
import Telecom.SupportService.exception.InternalServerError;
import Telecom.SupportService.exception.NotFoundException;
import Telecom.SupportService.model.Ticket;
import Telecom.SupportService.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@Slf4j
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTicket(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket getTicketById(@PathVariable Long id) throws NotFoundException {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/userId/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getTicketByUserId(@PathVariable Long userId) throws NotFoundException {
        return ticketService.getTicketByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createTicket(@RequestBody TicketDto TicketDto) throws NotFoundException, InternalServerError {
        ticketService.createTicket(TicketDto);
        return new ResponseMessage("Ticket created Successfully");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updateTicket(@RequestParam Long id, @RequestBody TicketDto TicketDto) throws NotFoundException, InternalServerError {
        ticketService.updateTicket(id, TicketDto);
        return new ResponseMessage("Ticket updated Successfully");
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteTicket(Long id) throws NotFoundException{
        ticketService.deleteTicket(id);
        return new ResponseMessage("Ticket Deleted Successfully");
    }
}
