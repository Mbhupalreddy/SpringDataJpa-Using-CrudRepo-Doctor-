package com.nt.service;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctor);
	public Long showDoctorsCount();
	public Boolean isDoctorAvailable(Integer id);
}
