package com.nt.service;

import java.util.List;
import java.util.Optional;
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

	@Override
	public Optional<Doctor> getDoctorId(Integer id) {
		//doctorRepo.findById(id);
		return doctorRepo.findById(id);
	}

	@Override
	public String registerDoctorOrUpdate(Doctor doctor) {
		Doctor save = doctorRepo.save(doctor);
		return "Doctor record is saved/Updated!!"+save;
	}

	@Override
	public String updateDoctorSpecialization(Integer id, String newspec) {
		Optional<Doctor> opt = doctorRepo.findById(id);
		if(opt.isPresent()) {
			Doctor doc = opt.get();
			doc.setSpecialization(newspec);
			doctorRepo.save(doc);
			return "Updated the new specialization!!\n";
		}
		return id+" "+"updation id not found!!";
	}

	@Override
	public String deleteDoctorbyId(Integer id) {
		Optional<Doctor> opt = doctorRepo.findById(id);
		if(opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id+"  the Doctor record is deleted!!";
		}
		return id+"  the record not  found and deleted!!";
	}

	@Override
	public String deleteDoctorAllEntity(Doctor doctor) {
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocid());
		if(opt.isEmpty()) {
			return " The table entity is not present/Found!!";
		}
		else {
			doctorRepo.delete(doctor);
			return"Table is found and deleted successfully!!";
		}
	}

	@Override
	public String removeAllDoctors() {
		long count = doctorRepo.count();
		if(count>0) {
			doctorRepo.deleteAll();
			return " No of Records are found and deleted!!  "+count;
		}
		return " NOOO Records found and  not deleted!!  "+count;
	}

	@Override
	public String removeAllDoctorsByIds(Iterable<Integer> ids) {
		Iterable<Doctor> list = doctorRepo.findAllById(ids);
		long count = StreamSupport.stream(list.spliterator(), false).count();
		//delete the records
		doctorRepo.deleteAllById(ids);
		return "deleted ids  "+count;
	}

}
