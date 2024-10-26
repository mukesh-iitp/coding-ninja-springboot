package railway.com.example.RailwayAndMeal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.exceptions.TicketAlreadyExistsException;
import railway.com.example.RailwayAndMeal.exceptions.TicketNotFoundException;

@Service
public class RailwayService {

	public List<Ticket> list = new ArrayList<>();
	public Map<Long,Ticket> ticketMap = new HashMap<>();

	public Ticket getTicketByPnr(long pnr) {
		if(ObjectUtils.isEmpty(ticketMap.get(pnr))) {
			throw new TicketNotFoundException("Ticket not found for pnr: "+pnr);
		}
		return ticketMap.get(pnr);
	}

	public void addTicket(Ticket ticket) {
		if(ticketMap.containsKey(ticket.getPnr())) {
			throw new TicketAlreadyExistsException("Ticket already present for pnr: "+ticket.getPnr());
		}
		list.add(ticket);
		ticketMap.put(ticket.getPnr(), ticket);
	}

	public List<Ticket> getAllTickets() {
		return list;
	}


	// Complete the method body to delete a ticket by PNR.
	public void deleteTicketByPnr(long pnr) {
		Ticket ticket = getTicketByPnr(pnr);
		list.remove(ticket);
		ticketMap.remove(pnr);
	}

	
	// Complete the method body to update an existing ticket.
	public void updateTicket(Ticket ticket) {
		Ticket existingTicket = getTicketByPnr(ticket.getPnr());
		list.remove(existingTicket);
		list.add(ticket);
		ticketMap.put(ticket.getPnr(), ticket);
	}

}