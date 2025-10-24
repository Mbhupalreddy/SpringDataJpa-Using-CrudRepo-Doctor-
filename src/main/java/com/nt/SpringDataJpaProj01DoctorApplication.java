package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgmtServiceImpl;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class SpringDataJpaProj01DoctorApplication {

    private final DoctorMgmtServiceImpl doctorService;


    SpringDataJpaProj01DoctorApplication(DoctorMgmtServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

   

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaProj01DoctorApplication.class, args);){
		//get service class obj
		IDoctorService service = ctx.getBean("doctorService",IDoctorService.class);
		// insert the records by using save
		/*try {
			//create Doctor class object
			Doctor doc = new Doctor();
			doc.setDocname("vijayadurga");
			doc.setSpecialization("KTR");
			doc.setIncome(105000.0);
			//invoke the b.method
			String msg = service.registerDoctor(doc);
			System.out.println(msg);
			}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		//by using the count method
		/*try {
			 
			System.out.println( "Doctors Count::"+service.showDoctorsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//is checking the doctor by existbyid
		try {
			Boolean flag = service.isDoctorAvailable(1);
			if(flag==true) {
				System.err.println("*****************Doctor is available***********");
			}
			else {
				System.err.println("Doctor is Not-available");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		/* here we used List<T> then we insert many
		Doctor doc1= new Doctor("mahesh", "heart", 150000.00);
		Doctor doc2= new Doctor("Ramesh", "kidney", 100000.00);
		Doctor doc3= new Doctor("vignesh", "urine", 125000.00);
		
		List<Doctor> list = List.of(doc1,doc2,doc3);
		
		try {
			String registerDoctor = service.registerDoctorsBatch(list);
			System.out.println(registerDoctor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(service.showDoctorById(9)); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
}


