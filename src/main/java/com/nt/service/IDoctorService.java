package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public Long showDoctorsCount();
	public Boolean isDoctorAvailable(Integer id);
	public String registerDoctorsBatch(List<Doctor> list);
}
