package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgmtServiceImpl;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class SpringDataJpaProj01DoctorApplication {

   

	public static void main(String[] args) {
		try(ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaProj01DoctorApplication.class, args);){
		//get service class obj
		IDoctorService service = ctx.getBean("doctorService",IDoctorService.class);
		
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
		try {
			 
			System.out.println( "Doctors Count::"+service.showDoctorsCount());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
}


