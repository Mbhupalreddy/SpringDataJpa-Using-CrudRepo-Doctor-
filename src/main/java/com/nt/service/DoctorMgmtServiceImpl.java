package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

	@Override
	public String registerDoctorsBatch(List<Doctor> list) {
		Iterable<Doctor> saveDoc = doctorRepo.saveAll(list);
		List<Integer> ids = StreamSupport.stream(saveDoc.spliterator(), false).map(Doctor::getDocid).collect(Collectors.toList());
	    return ids.size()+"no.of Doctors are registered having the idvalues"+ids;
	}
/*   findbyId(),  																				*/
	@Override
	public Doctor showDoctorById(Integer id) {
//		Doctor dutydoc=new Doctor();
//		dutydoc.setSpecialization("heart");
		Doctor doctor = doctorRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid data"));
		return doctor;
	}

}
