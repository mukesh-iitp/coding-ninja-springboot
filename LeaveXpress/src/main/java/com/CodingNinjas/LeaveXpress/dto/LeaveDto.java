package com.CodingNinjas.LeaveXpress.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String type;

	private String startDate;

	private String endDate;

	private String description;

}
