package com.CodingNinjas.LeaveXpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodingNinjas.LeaveXpress.model.LeaveModel;

public interface LeaveRepository extends JpaRepository<LeaveModel, Long>{
	
	List<LeaveModel> findByIsAccepted(boolean b);

}
