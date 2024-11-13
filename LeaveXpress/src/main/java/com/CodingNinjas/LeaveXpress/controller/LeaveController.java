package com.CodingNinjas.LeaveXpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	/*
	GET “/api/leave/{id}” (@PathVariable Long id)
	: This API allows the employee to fetch a Leave record by its ID. It returns an OK response status.

    GET "/api/leave/all"
	: This API allows employees to fetch all Leaves records. It returns an OK response status.

    GET "/api/leave/accepted"
	: This API allows employees to fetch all accepted Leave Records. It returns an OK response status.

    GET "/api/leave/rejected"
	: This API allows employees to fetch all rejected Leave  Records. It returns an OK response status.

    GET "/api/leave/status/{id}" (@PathVariable Long id)
	: This API allows the employee to fetch a Leave Record status by its ID. It returns an OK response status.

    PUT "/api/leave/{id}" (@PathVariable Long id, @RequestBody LeaveDto updatedLeave)
	: This API allows the employee to update a Leave Record by its ID. It returns an OK response status.

    DELETE "/api/leave/{id}" (@PathVariable Long id)
	: This API allows the employee to delete a Leave Record by its ID. It returns an OK response status.

  	POST "/api/leave/apply" (@RequestBody LeaveDto leaveRequest)
	: This API allows the employees to apply for a leave. It returns an OK response status.

    POST "/api/leave/accept/{id}" (@PathVariable Long id)
	: This API allows the manager to accept a Leave Record by its ID. It returns an ACCEPTED response status.

    POST "/api/leave/reject/{id}" (@PathVariable Long id)
	: This API allows the manager to reject a Leave Record by its ID. It returns an OK response status.

	 */

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public LeaveModel getLeaveById(@PathVariable Long id) {
		return leaveService.getLeaveById(id);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public List<LeaveModel> getAllLeaves() {
		return leaveService.getAllLeaves();
	}

	@GetMapping("/accepted")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public List<LeaveModel> getAcceptedLeaves() {
		List<LeaveModel> acceptedLeaves = leaveService.getAcceptedLeaves();
		return acceptedLeaves;
	}

	@GetMapping("/rejected")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public List<LeaveModel> getRejectedLeaves() {
		List<LeaveModel> rejectedLeaves = leaveService.getRejectedLeaves();
		return rejectedLeaves;
	}

	@GetMapping("/status/{id}")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public boolean getLeaveStatus(@PathVariable Long id) {
		return leaveService.getLeaveStatus(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public void updateLeave(@PathVariable Long id, @RequestBody LeaveDto updatedLeave) {
		leaveService.updateLeave(id, updatedLeave);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public void deleteLeave(@PathVariable Long id) {
		leaveService.deleteLeave(id);
	}

	@PostMapping("/apply")
	@PreAuthorize("hasAnyRole('EMPLOYEE','MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public void applyForLeave(@RequestBody LeaveDto leaveDto) {
		leaveService.applyForLeave(leaveDto);
	}

	@PostMapping("/accept/{id}")
	@PreAuthorize("hasRole('MANAGER')")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void acceptLeave(@PathVariable Long id) {
		leaveService.acceptLeave(id);
	}

	@PostMapping("/reject/{id}")
	@PreAuthorize("hasRole('MANAGER')")
	@ResponseStatus(HttpStatus.OK)
	public void rejectLeave(@PathVariable Long id) {
		leaveService.rejectLeave(id);
	}


}
