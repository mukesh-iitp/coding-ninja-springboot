package com.CN.Gym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {

	/* This is the Workout Dto class, and you need to complete the class by doing the following:
     a. Add the following attributes:
       1. String workoutName
       2. String description
       3. String difficultyLevel
       4. int duration
     b. Use lombok annotations for getter, setters and constructors
	 */

	private String workoutName;
	private String description;
	private String difficultyLevel;
	private int duration;

}
