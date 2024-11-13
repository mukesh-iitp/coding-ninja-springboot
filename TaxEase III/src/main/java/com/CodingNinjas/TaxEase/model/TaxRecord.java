package com.CodingNinjas.TaxEase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    This is the entity class, complete this class by doing the following:

    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String taxYear;
	private int Income;
	private int deductions;
	private boolean isFilingApproved;

}
