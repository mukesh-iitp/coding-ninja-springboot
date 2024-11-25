package com.CN.Gym.dto;

import java.util.ArrayList;
import java.util.List;

import com.CN.Gym.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GymDto {

    /* This is the Gym Dto class, and you need to complete the class by doing the following:
     a. Add the following attributes:
       1. String name
       2. String address
       3. Long contactNo
       4. String membershipPlans
       5. String facilities
       6. List<User> members = new ArrayList<>()
     b. Use lombok annotations for getter, setters and constructors
     */
	
	private String name;
	private String address;
	private Long contactNo;
	private String membershipPlans;
	private String facilities;
	private List<User> members = new ArrayList<>();

}
