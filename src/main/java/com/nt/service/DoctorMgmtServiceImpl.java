package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IDoctorRepo;
import com.nt.entity.Doctor;
@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("doc id(before save::"+doctor.getDocid());
		Doctor doc = doctorRepo.save(doctor);
		return "******Doctor obj is saved with id value*****:"+doc.getDocid();
	}

	@Override
	public Long showDoctorsCount() {
		long count = doctorRepo.count();
		return count;
	}

	@Override
	public Boolean isDoctorAvailable(Integer id) {
		boolean byId = doctorRepo.existsById(id);
		return byId;
	}

}
