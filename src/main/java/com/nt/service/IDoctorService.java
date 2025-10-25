package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public Long showDoctorsCount();
	public Boolean isDoctorAvailable(Integer id);
	public String registerDoctorsBatch(List<Doctor> list);
	
	//finder methods and update operations findbyId()
	public Doctor showDoctorById(Integer id);
	public Optional<Doctor> getDoctorId(Integer id);
	
	//Update
	public String registerDoctorOrUpdate(Doctor doctor);
	//partial update
	public String updateDoctorSpecialization(Integer id,String newspec);
	//deletebyid 
	public String deleteDoctorbyId(Integer id);
	//delete
	public  String deleteDoctorAllEntity(Doctor doctor);
	//deleteAll
	public String removeAllDoctors();
	//deleteAllByIds(Iterable<Integer> id)
	public String removeAllDoctorsByIds(Iterable<Integer> ids);
}
